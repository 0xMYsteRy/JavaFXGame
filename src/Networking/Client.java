package Networking;


import Menu_JAVA.MainMenu;
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
    Scene scene;
    Socket socket;
    Server server;
    ObjectOutputStream output;
    ObjectInputStream input;
    Stage stage;

    @Override
    public void handle(KeyEvent e) {
        System.out.println("ok");
        if (e != null) {
            System.out.println(e.getCode());
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
            System.out.println(" Connected in  Client");
            //Connection successful

            //create a thread in order to read message from server continuously
            TaskReadThread task = new TaskReadThread(socket, this);
            Thread thread = new Thread(task);
            thread.start();


            // Create an output stream to send data to the server

            new Thread(()->{
                try {
                    output = new ObjectOutputStream(socket.getOutputStream());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException ex) {
            System.out.println("a");

        }
//        stage.show();
    }
}

