package Nguyen_Net;


import Map_JAVA.MapJungle;
import Tank_JAVA.Tank;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class N_Server extends Application {
    private Scene scene;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private int numOfConnected;

    private static InputStream inputStream;
    private static OutputStream outputStream;
    private int tankIndex;
    List<Socket> connectionList = new ArrayList<Socket>();
    private int playerCount = 0;

    private static void log(String str) {
        System.out.println(str);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tank Battle");
        Pane tankPane;
        tankPane = new Pane();
        MapJungle map = new MapJungle();
        map.loadGround(tankPane);
        scene = new Scene(tankPane, 1400, 750);//1400x750
        //Create Player
        Tank tankClient = new Tank(1, 2);
        Tank tankClient2 = new Tank(2, 3);

        tankClient.createPlayer(0, 630, tankPane, scene, map.getRectList(), map.getobjectList(), map.getObjBotList(), null, true, 2);
        tankClient2.createPlayer(0, 70, tankPane, scene, map.getRectList(), map.getobjectList(), map.getObjBotList(), null, true, 3);
        stage.setScene(scene);
        stage.show();
        /*
         **The issue here is that loop is running on the main application thread,
         **so it locks any GUI updates until it's completed.
         **Perform the loop on its own thread
         */

        // Running multi thread
        // Keep the server alive

        new Thread(() -> {
            ServerSocket ss = null;
            try {
                ss = new ServerSocket(80);
            } catch (IOException e) {
                e.printStackTrace();
            }
            log("+----+--------+--------+------------+---------------------+ \n" +
                    "| ID | NAME   |  MODE  |   STATUS   |      Memory         | \n" +
                    "+----+--------+--------+------------+---------------------+ \n" +
                    "|  0 | Server |  fork  |   online   |      10.5mb         | \n" +
                    "+----+--------+--------+------------+---------------------+ ");
            System.out.println("\nServer started! Awaiting connections...");
            ServerSocket finalSs = ss;
            try {
                socket = finalSs.accept();
                log("+A client connected from " + socket.getInetAddress() + " running on port " + socket.getPort());
                connectionList.add(socket);
                playerCount++;
                tankIndex = playerCount;
                outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.write(playerCount);

                DataInputStream dataInputStream;
                dataInputStream = new DataInputStream(socket.getInputStream());
                ObjectInputStream objectInputStream;
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                while (true) {
                    try {
                        KeyEvent message = (KeyEvent) objectInputStream.readObject();
                        switch (tankIndex) {
                            case 1:
                                Platform.runLater(() -> {
                                    try {
                                        tankClient.moveClient(message);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    tankClient.ShootClient(message);
                                });
                                break;
                            case 2:
                                Platform.runLater(() -> {
                                    try {
                                        tankClient2.moveClient(message);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    tankClient2.ShootClient(message);
                                });
                                break;
                        }
                        objectInputStream.reset();
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //}
        }).start();
        // Read simutaneously

        // Send a message to the client
        new Thread(() -> {
            try {
                outputStream = socket.getOutputStream();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//                objectOutputStream.writeObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


    // In case want to close server
    public void closeServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}


