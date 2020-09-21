
package Nguyen_Net;


import Map_JAVA.MapJungle;
import Tank_JAVA.Tank;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;


public class N_Client extends Application implements Serializable {
    private static ObjectOutputStream toServer;
    private static Scene scene;
    private static KeyEvent keyEvent;
    private static Socket socket;
    private static ObjectOutputStream output;
    private static DataInputStream inputData;
    private static DataOutputStream outputData;
    private static int tankIndex;

    private static void log(String str) {
        System.out.println(str);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //System.out.println("Not OK");

                Socket socket = new Socket("localhost", 80);
                log("Connecting to Server " + socket.getRemoteSocketAddress() + " running on port " + socket.getPort());
                Pane tankPane;
                tankPane = new Pane();
                //Load the map
                MapJungle map = new MapJungle();
                map.loadGround(tankPane);
                scene = new Scene(tankPane, 1400, 770);

                //Create Player
                Tank b = new Tank(1, 2);
                b.createPlayer(0, 630, tankPane, scene, map.getRectList(), map.getobjectList(), map.getObjBotList(), null, true, 1);
                output = new ObjectOutputStream(socket.getOutputStream());
                inputData = new DataInputStream(socket.getInputStream());
                outputData = new DataOutputStream(socket.getOutputStream());
                tankIndex = inputData.read();
                System.out.println("Tank index: " + tankIndex);

                b.setClient(this);
                primaryStage.setTitle("Client Tank Battle");
                primaryStage.setScene(scene);
                primaryStage.show();


    }

    public void movingClient(KeyEvent e) {
        switch (e.getCode()) {
            case DOWN:
                System.out.println("DOWN");
                try {
//                        output = new ObjectOutputStream(socket.getOutputStream());
                    output.writeObject(e);
                    output.flush();
                    output.reset();
                    System.out.println("Send to the server " + output);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case UP:
                System.out.println("UP");
                try {
//                        output = new ObjectOutputStream(socket.getOutputStream());
                    output.writeObject(e);
                    output.flush();
                    output.reset();
                    System.out.println("Send to the server" + output);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case LEFT:

                System.out.println("LEFT");
                try {
//                        output = new ObjectOutputStream(socket.getOutputStream());
                    output.writeObject(e);
                    output.flush();
                    output.reset();
                    System.out.println("Send to the server " + output);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case RIGHT:
                System.out.println("RIGHT");
                try {
//                        output = new ObjectOutputStream(socket.getOutputStream());
                    output.writeObject(e);
                    output.flush();
                    output.reset();
                    System.out.println("Send to the server" + output);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
        }
    }

    public void shootingClient(KeyEvent e) {
        System.out.println("Space");
        try {
//                        output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(e);
            output.flush();
            output.reset();
            System.out.println("Send to the server " + output);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
//        scene.setOnKeyPressed(e -> {
//            switch (e.getCode()) {
//                case DOWN:
//                    System.out.println("DOWN");
//                    try {
////                        output = new ObjectOutputStream(socket.getOutputStream());
//                        output.writeObject(e.getCode());
//                        output.flush();
//                        output.reset();
//                        System.out.println("Send to the server " + output);
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//                    break;
//                case UP:
//                    System.out.println("UP");
//                    try {
////                        output = new ObjectOutputStream(socket.getOutputStream());
//                        output.writeObject(e);
//                        output.flush();
//                        output.reset();
//                        System.out.println("Send to the server" + output);
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//                    break;
//                case LEFT:
//                    System.out.println("LEFT");
//                    try {
////                        output = new ObjectOutputStream(socket.getOutputStream());
//                        output.writeObject(e);
//                        output.flush();
//                        output.reset();
//                        System.out.println("Send to the server " + output);
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//                    break;
//                case RIGHT:
//                    System.out.println("RIGHT");
//                    try {
////                        output = new ObjectOutputStream(socket.getOutputStream());
//                        output.writeObject(e);
//                        output.flush();
//                        output.reset();
//                        System.out.println("Send to the server" + output);
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//                    break;
//            }
//        });

