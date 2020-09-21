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
    private ObjectOutputStream output;
    private int numOfConnected;
    private Stage stage;
    private static InputStream inputStream;
    private static OutputStream outputStream;
    private KeyEvent keyEvent1,keyEvent2;

    private static void log(String str) {
        System.out.println(str);
    }

    List<TaskClientConnection> connectionList = new ArrayList<>();

    public void loadScenePvP(){
        stage.setTitle("Loading an image");
        Pane tankPane;
        tankPane = new Pane();
        MapJungle map = new MapJungle();
        map.loadGround(tankPane);
        scene = new Scene(tankPane, 1400, 770);//1400x750
        Tank b = new Tank(2, 1);
        b.createPlayer(350, 350, tankPane, scene, map.getRectList(), map.getobjectList(), map.getObjBotList(),null,true, 1);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        loadScenePvP();
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
            //Create socket
            try {
                ServerSocket serverSocket = new ServerSocket(ConnectionUtil.port);
                while (true) {
                    // Listen for a connection request, add new connection to the list
                    System.out.println("[Server]: Awaiting for connections ...");
                    socket = serverSocket.accept();
                    log("[Server]: A client connected from " + socket.getInetAddress() + " running on port " + socket.getPort());
//                    TaskClientConnection connection = new TaskClientConnection(socket, this, connectionList.size());
//                    connectionList.add(connection);

                    //create a new thread
//                    Thread thread = new Thread(connection);
//                    thread.start();
                    try {
                        System.out.println("Before input stream");
                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                        String message = objectInputStream.readObject().toString();
                        System.out.println("Msg from client: " + message);

                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                        System.out.println("Error ");
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            while (true) {
            }
        }).start();
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


