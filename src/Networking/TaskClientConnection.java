package Networking;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.io.*;
import java.net.Socket;

public  class TaskClientConnection implements Runnable {

    Socket socket;
    Server server;
    // Create data input and output streams
    ObjectInputStream input;
    ObjectOutputStream output;
    Scene scene ;
    public TaskClientConnection(Socket socket, Server server) {
        System.out.println("Connected this client to the server");
        this.socket = socket;
        this.server = server;
    }
    KeyEvent keyEvent;
    @Override
    public void run() {

        try {
            // Create data input and output streams
            input = new ObjectInputStream(
                    socket.getInputStream());
            output = new ObjectOutputStream(
                    socket.getOutputStream());
                System.out.println("Getting message");
            server.broadcast(scene);
            while (true) {
                // Get message from the client
                KeyEvent message = (KeyEvent) input.readObject();
                //send message via server broadcast
                scene.setOnKeyPressed(evt -> {
                    System.out.println(" Sending message to  server");
                    server.broadcast(scene);
                });

//                //append message of the Text Area of UI (GUI Thread)
//                Platform.runLater(() -> {
//                    server.txtAreaDisplay.appendText(message + "\n");
//                });
            }



        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    //send message back to client
    public void sendMessage(Scene scene) {
        try {
            System.out.println("Sending message");
            output.writeObject(scene);
            output.flush();
            System.out.println(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

