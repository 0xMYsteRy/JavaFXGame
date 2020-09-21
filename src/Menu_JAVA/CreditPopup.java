package Menu_JAVA;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreditPopup extends Application {
    Pane root = new Pane();

    public Parent popupContent() {
        root.setPrefSize(400, 200);

        Text s1 = new Text("Technical leader: Nguyen Thanh Luan");
        Text s2 = new Text("Project manager: Nguyen Quoc Huy");
        Text s3 = new Text("Networking specialist: Le Nguyen");
        Text s4 = new Text("GUI designer: Le Anh Quan");
        VBox credit = new VBox(10, s1, s2, s3, s4);
        credit.setTranslateX(20);
        credit.setTranslateY(10);

        Button closeButton = new Button("Close");
        closeButton.setMinWidth(400);
        closeButton.setMinHeight(20);
        closeButton.setTranslateY(170);
        closeButton.setOnMouseClicked(this::handleCloseButtonAction2);

        root.getChildren().addAll(credit, closeButton);

        return root;
    }

    public void handleCloseButtonAction2(MouseEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene credit = new Scene(popupContent());
        stage.setTitle("Credit");
        stage.setScene(credit);
        stage.show();
    }
}
