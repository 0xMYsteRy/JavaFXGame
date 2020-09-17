package Networking;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client extends Application implements EventHandler<KeyEvent> {

    //Get key
    Socket socket;
    Server server;
    // Create data input and output streams
    DataInputStream input;
    DataOutputStream output;
    Stage stage;
    @Override
    public void handle(KeyEvent e) {
        if (e != null) {
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

    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        stage.setTitle("LOL");

        try {
            // Create a socket to connect to the server
            Socket socket = new Socket(ConnectionUtil.host, ConnectionUtil.port);

            //Connection successful


            // Create an output stream to send data to the server
            output = new DataOutputStream(socket.getOutputStream());

            //create a thread in order to read message from server continuously
            TaskReadThread task = new TaskReadThread(socket, this);
            Thread thread = new Thread(task);
            thread.start();
        } catch (IOException ex) {
            System.out.println("a");

        }

    }
}

