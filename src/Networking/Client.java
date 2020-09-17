package Networking;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
        Socket socket = new Socket("10.247.169.255", 8080);
        log("Connecting to Server " + socket.getRemoteSocketAddress() + " running on port " + socket.getPort());
        while (true) {
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            //System.out.println("Sending messages to the ServerSocket");
            //TODO: Get the key event here
            List<Message> messages = new ArrayList<>();
            messages.add(new Message(send(keyEvent)));
            objectOutputStream.writeObject(messages);
            //System.out.println("OK");
        }
    }

    static String send(KeyEvent keyEvent) throws IOException {
        try {
            toServer.writeObject(keyEvent);
            System.out.println("OK");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toServer.toString();
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
class Message implements Serializable {
    private final String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}