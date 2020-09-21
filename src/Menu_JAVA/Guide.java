package Menu_JAVA;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Guide extends Application {
    Pane root = new Pane();
    CreditPopup creditPopup = new CreditPopup();

    public Parent guideWindow() {
        root.setPrefSize(800, 600);

        ImageView arrow = new ImageView("file:src/Menu_JAVA/res/mod-arrows.png");
        arrow.setTranslateX(20);
        arrow.setFitHeight(200);
        arrow.setFitWidth(300);

        ImageView space = new ImageView("file:src/Menu_JAVA/res/space_key_s.png");
        space.setTranslateX(20);
        space.setTranslateY(250);
        space.setFitWidth(300);
        space.setFitHeight(100);

        Text move = new Text("To move");
        move.setFont(Font.loadFont(Guide.class.getResource("res/Penumbra-HalfSerif-Std_35114.ttf").toExternalForm(), 30));
        move.setTranslateX(350);
        move.setTranslateY(80);

        Text shoot = new Text("To shoot the enemies");
        shoot.setFont(Font.loadFont(Guide.class.getResource("res/Penumbra-HalfSerif-Std_35114.ttf").toExternalForm(), 30));
        shoot.setTranslateX(350);
        shoot.setTranslateY(280);

        Button closeButton = new Button("Close");
        closeButton.setMinWidth(800);
        closeButton.setMinHeight(30);
        closeButton.setTranslateY(570);
        closeButton.setOnMouseClicked(e -> {
            creditPopup.handleCloseButtonAction2(e);
        });

        root.getChildren().addAll(arrow, space, move, shoot, closeButton);
        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene guide = new Scene(guideWindow());
        stage.setScene(guide);
        stage.setTitle("How to play");
        stage.show();

    }
}
