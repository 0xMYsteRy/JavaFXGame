/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author topman garbuja,
 * 
 * It is used to get input from server simultaneously
 */
public class TaskReadThread implements Runnable {
    //private variables
    Socket socket;
    Client client;
    ObjectInputStream input;
    Stage stage2= new Stage();
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
                //Create data input stream
                input = new ObjectInputStream(socket.getInputStream());

                //get input from the client
                Scene message= (Scene) input.readObject();
                System.out.println(message);
                //append message of the Text Area of UI (GUI Thread)
                Platform.runLater(() -> {
                    //display the message in the textarea
                    System.out.println("hello World");
                    stage2.setScene(message);
                    stage2.show();
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
