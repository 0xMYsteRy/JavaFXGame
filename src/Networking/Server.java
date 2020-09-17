package Networking;


import Map_JAVA.MapJungle;
import Tank_JAVA.Tank;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Server extends Application {
    private Scene scene;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private int numOfConnected;

    private static InputStream inputStream;
    private static OutputStream outputStream;


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

        tankClient.createPlayer(0, 630, tankPane, scene, map.getRectList(), map.getobjectList(), map.getObjBotList());
        tankClient2.createPlayer(0, 70, tankPane, scene, map.getRectList(), map.getobjectList(), map.getObjBotList());

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

                ss = new ServerSocket(8080);

            } catch (IOException e) {
                e.printStackTrace();
            }
            log("+----+--------+--------+------------+---------------------+ \n" +
                    "| ID | NAME   |  MODE  |   STATUS   |      Memory         | \n" +
                    "+----+--------+--------+------------+---------------------+ \n" +
                    "|  0 | Server |  fork  |   online   |      10.5mb         | \n" +
                    "+----+--------+--------+------------+---------------------+ ");
            System.out.println("\nServer started! Awaiting connections...");

            while (true) {
                Socket socket = null;
                try {
                    assert ss != null;
                    socket = ss.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //System.out.println("Connection from " + socket + "!");
                assert socket != null;
                log("+A client connected from " + socket.getInetAddress() + " running on port " + socket.getPort());
            }
        }).start();


        //TODO: Receive the msg from the client
        new Thread(() -> {

            try {
                assert socket != null;
                inputStream = socket.getInputStream();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                // Read the message form the client

                List<Message> listOfMessages = (List<Message>) objectInputStream.readObject();
                System.out.println("Received [" + listOfMessages.size() + "] messages from: " + socket);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();

        // Send a message to the client
        new Thread(() -> {
            try {
                assert socket != null;
                outputStream = socket.getOutputStream();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                ObjectOutputStream objectOutputStream  = new ObjectOutputStream(outputStream);

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

class IPAddress {
    public static String getIPAddress() {
        InetAddress ip = null;
        try {

            ip = InetAddress.getLocalHost();
            System.out.println("Server created successfully! Waiting for players ... ");
            //System.out.println("Server IP address : " + ip.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        assert ip != null;
        return ip.getHostAddress();
    }
}

