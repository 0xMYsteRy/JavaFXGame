package Networking;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread implements EventHandler<KeyEvent> {
    private static ObjectOutputStream toServer;
    private static Scene scene;
    private static String Msg;
    private static KeyEvent keyEvent;
    private static Socket socket;
    private static OutputStream outputStream;
    private static ObjectOutputStream objectOutputStream;

    //Get key
    Client(ObjectOutputStream toServer) {
        Client.toServer = toServer;
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.247.169.35", 80);
        log("Connecting to Server "+ socket.getRemoteSocketAddress()+ " running on port "+ socket.getPort());
        //while (true){
        outputStream = socket.getOutputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);
        System.out.println("Sending messages to the ServerSocket");


        //TODO: Get the key event here
        objectOutputStream.writeObject(keyEvent);

        System.out.println("OK");
        //}
    }
    void send(KeyEvent keyEvent){
        try {
            toServer.writeObject(keyEvent);
            System.out.println("OK");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
    }
    @Override
    public void handle(KeyEvent e) {
        if (keyEvent != null) {
            switch (e.getCode()) {
                case DOWN:
                    System.out.println("Sent to server");
                    break;
                case UP:
                    break;
                case LEFT:
                    break;
                case RIGHT:
                    break;
            }
        }
    }
    private static void log(String str) {
        System.out.println(str);
    }
}
