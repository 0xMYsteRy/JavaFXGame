/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

/**
 * 000000
 *
 * @author topman garbuja,
 * <p>
 * It is used to get input from server simultaneously
 */
public class TaskReadThread implements Runnable {
    //private variables
    Socket socket;
    Client client;
    ObjectInputStream input;

    //constructor
    public TaskReadThread(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
    }

    @Override
    public void run() {
        //continuously loop it
        System.out.println("Running TaskThread");
        while (true) {
            try {
                KeyEvent keyEvent1, keyEvent2, keyEvent3, keyEvent4;

                //Create data input stream
                input = new ObjectInputStream(socket.getInputStream());

                //get input from the client
                keyEvent1 = (KeyEvent) input.readObject();
                System.out.println("1");
                //append message of the Text Area of UI (GUI Thread)
                Platform.runLater(() -> {
                    //display the message in the textarea
                    System.out.println("hello World");
                    client.keyEvent = keyEvent1;
                });
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                break;
            }
        }
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
