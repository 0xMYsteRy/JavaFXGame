package Networking;

import Tank_JAVA.Tank;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

/**
 * @author topman garbuja,It represents each new connection
 */
public class TaskClientConnection implements Runnable, Serializable {

    Socket socket;
    Server server;
    // Create data input and output streams
    ObjectInputStream input;
    ObjectOutputStream output;
    int playerIndex;

    public TaskClientConnection(Socket socket, Server server, int index) {
        System.out.println("Connected this client to the server");
        this.socket = socket;
        this.server = server;
        this.playerIndex = index;
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
//            int color = input.read();
//            int choice = input.read();
            //server.sendInitial(color, choice, playerIndex);

//                server.sendKey1(keyEvent1);

            //append message of the Text Area of UI (GUI Thread)
//                Platform.runLater(() -> {
//                    server.txtAreaDisplay.appendText(message + "\n");
//                });
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        KeyEvent keyEvent1;

    }

    //send message back to client
    public void sendMessage(KeyEvent keyEvent) {
        try {
            System.out.println("Sending message back ");
            output.writeObject(keyEvent);
            output.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendInitial(int Color, int Choice, int Pos) {
        try {
            System.out.println("Sending message back ");
            output.writeInt(Color);
            output.write(Choice);
            output.write(Pos);
            output.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

