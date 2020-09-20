package Networking;


import Map_JAVA.MapJungle;
import Tank_JAVA.Tank;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
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
public class Server extends Application implements Serializable {
    private Scene scene;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private int numOfConnected;
    private Stage stage;
    private static InputStream inputStream;
    private static OutputStream outputStream;
    private KeyEvent keyEvent1,keyEvent2;

    private static void log(String str) {
        System.out.println(str);
    }

    List<TaskClientConnection> connectionList = new ArrayList<TaskClientConnection>();

    public  void loadScenePvP(){
        stage.setTitle("Loading an image");
        Pane tankPane;
        tankPane = new Pane();
        //Load the map
        MapJungle map = new MapJungle();

        map.loadGround(tankPane);
        scene = new Scene(tankPane, 1400, 770);//1400x750
        //Create Player
//        Tank b = new Tank(2, 1);
//        b.createPlayer(350, 350, tankPane, scene, map.getRectList(), map.getobjectList(), map.getObjBotList(), 1);
        //Create Bot
//        map.loadBot(tankPane, b, scene);
        //Adding scene to the stage
//        map.loadObject(tankPane);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        loadScenePvP();

        stage.setScene(scene);



        new Thread(() -> {
            //Create socket
            try {
                ServerSocket serverSocket = new ServerSocket(ConnectionUtil.port);


                while (true) {
                    // Listen for a connection request, add new connection to the list
                    System.out.println("Listening");
                    socket = serverSocket.accept();

                    TaskClientConnection connection = new TaskClientConnection(socket, this, connectionList.size());
                    connectionList.add(connection);

                    //create a new thread
                    Thread thread = new Thread(connection);
                    thread.start();

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
        stage.show();
    }

    //send message to all connected clients
    public void sendKey1(KeyEvent keyEvent1) {
        for (TaskClientConnection clientConnection : this.connectionList) {
            System.out.println("Sending message to all client from server");
            clientConnection.sendMessage(keyEvent1);
        }
    }
    public void sendKey2(KeyEvent keyEvent2) {
        for (TaskClientConnection clientConnection : this.connectionList) {
            System.out.println("Sending message to all client from server");
            clientConnection.sendMessage(keyEvent2);
        }
    }
    public void sendInitial (int Color,int Choice,int Pos) {
        for (TaskClientConnection clientConnection : this.connectionList) {
            System.out.println(Color+" "+Choice+" "+Pos);
            System.out.println("Sending message to all client from server");
            clientConnection.sendInitial(Color,Choice,Pos);
        }
    }

}


