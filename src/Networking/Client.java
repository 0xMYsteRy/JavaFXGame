package Networking;

//--module-path "/YOUR/PATH/TO/javafx-sdk-11.0.2/lib" --add-modules javafx.controls,javafx.fxml*/

import Map_JAVA.MapJungle;
import Menu_JAVA.MainMenu;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client extends Application implements EventHandler<KeyEvent>, Serializable {
    Socket socket;
    ObjectOutputStream output;
    ObjectInputStream input;

    KeyEvent keyEvent;
    TextField txtName, txtInput;

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
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("LOL");
        //javafx.controls
        //--module-path "/YOUR/PATH/TO/javafx-sdk-11.0.2/lib" --add-modules javafx.controls,javafx.fxml*/


        MapJungle map = new MapJungle();
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        txtName = new TextField();
        txtName.setPromptText("Choose color (0-4): ");
        txtName.setTooltip(new Tooltip("Write your Color. "));
        txtInput = new TextField();
        txtInput.setPromptText("Choose choice (0-4): ");
        txtInput.setTooltip(new Tooltip("Write your Choice. "));
        Button btnSend = new Button("Send");
        btnSend.setOnAction(new ButtonListener());
        vBox.getChildren().addAll(hBox);

        hBox.getChildren().addAll(txtName, txtInput, btnSend);
        vBox.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                event.consume();
                System.out.println("A");
            }
        });

        HBox.setHgrow(txtInput, Priority.ALWAYS);  //set textfield to grow as window size grows
        Pane tankPane;
        tankPane = new Pane();
        Scene scene = new Scene(tankPane, 1400, 770);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
                    System.out.println("DOWN");
                    try {
                        output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeObject(e.getCode());
                        output.flush();
                        output.reset();
                        System.out.println("Send to the server "+output);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;
                case UP:
                    System.out.println("UP");
                    try {
                        output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeObject(e);
                        output.reset();
                        System.out.println("Send to the server");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;
                case LEFT:
                    System.out.println("LEFT");
                    try {
                        output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeObject(e);
                        output.reset();
                        System.out.println("Send to the server");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;
                case RIGHT:
                    System.out.println("RIGHT");
                    try {
                        output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeObject(e);
                        output.reset();
                        System.out.println("Send to the server");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;
            }});
        primaryStage.setTitle("Client Tank Battle");
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            // Create a socket to connect to the server
            socket = new Socket(ConnectionUtil.host, ConnectionUtil.port);
            System.out.println("Connected");
            //Connection successful

            //create a thread in order to read message from server continuously
            TaskReadThread task = new TaskReadThread(socket, this);
            Thread thread = new Thread(task);
            thread.start();


            // Create an output stream to send data to the server
            output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static class ButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
 //           try {
                //get username and message
//                String Color = txtName.getText().trim();
//                String Choice = txtInput.getText().trim();

                //if username is empty set it to 'Unknown'
//                if (Color.length() == 0) {
//                    Color = "Unknown";
//                }
//                //if message is empty, just return : don't send the message
//                if (Choice.length() == 0) {
//                    return;
//                }

                //send message to server
//                output.write(Integer.parseInt(Color));
//                output.write(Integer.parseInt(Choice));
//                output.flush();
//
//                //clear the textfield
//                txtInput.clear();
//            } catch (IOException ex) {
//                ex.getStackTrace();
//            }
        }
    }
}