package Networking;


import Map_JAVA.MapJungle;
import Tank_JAVA.Tank;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
//http://www.java2s.com/Tutorials/Java/Socket/How_to_read_data_from_Socket_connectin_using_Java.htm
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

    List<TaskClientConnection> connectionList = new ArrayList<TaskClientConnection>();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Loading an image");
        Pane tankPane;
        tankPane = new Pane();
        MapJungle map = new MapJungle();
        map.loadGround(tankPane);
        scene = new Scene(tankPane, 1400, 770);//1400x75


        Tank b = new Tank(2, 1);
        b.createPlayer(350, 350, tankPane, scene, map.getRectList(), map.getobjectList(), map.getObjBotList(), 1);

        stage.setScene(scene);
        stage.show();


        new Thread(() -> {
            //Create socket
            try {
                ServerSocket serverSocket = new ServerSocket(ConnectionUtil.port);

                while (true) {
                    // Listen for a connection request, add new connection to the list

                    socket = serverSocket.accept();

                    TaskClientConnection connection = new TaskClientConnection(socket, this);
                    connectionList.add(connection);

                    //create a new thread
                    Thread thread = new Thread(connection);
                    thread.start();

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    //send message to all connected clients
    public void broadcast(Scene scene) {
        for (TaskClientConnection clientConnection : this.connectionList) {
            clientConnection.sendMessage(scene);
        }
    }
}


