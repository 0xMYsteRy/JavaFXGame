package Tank_JAVA;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.Serializable;

public class Flash implements Serializable {
    ImageView[] Imagelist = new ImageView[10];


    private double duration = 50;

    public Flash() {
        Imagelist[0] = new ImageView(new Image("file:src/PNG/Effects/Flash_A_01.png"));
        Imagelist[1] = new ImageView(new Image("file:src/PNG/Effects/Flash_A_02.png"));
        Imagelist[2] = new ImageView(new Image("file:src/PNG/Effects/Flash_A_03.png"));
        Imagelist[3] = new ImageView(new Image("file:src/PNG/Effects/Flash_A_04.png"));
        Imagelist[4] = new ImageView(new Image("file:src/PNG/Effects/Flash_A_05.png"));
        Imagelist[5] = new ImageView(new Image("file:src/PNG/Effects/Flash_B_01.png"));
        Imagelist[6] = new ImageView(new Image("file:src/PNG/Effects/Flash_B_02.png"));
        Imagelist[7] = new ImageView(new Image("file:src/PNG/Effects/Flash_B_03.png"));
        Imagelist[8] = new ImageView(new Image("file:src/PNG/Effects/Flash_B_04.png"));
        Imagelist[9] = new ImageView(new Image("file:src/PNG/Effects/Flash_B_05.png"));
    }

    public void FlashAnimation(double x, double y, double rotation, double size, int choice, Pane pane) {
        Group FlashSet = new Group(Imagelist[(choice - 1) * 5]);
        Timeline flashTimeline = new Timeline();
        flashTimeline.setCycleCount(1);

        for (int i = 5 * (choice) - 4; i < 5 * choice; i++) {
            Imagelist[i].setFitWidth(size);
            Imagelist[i].setFitHeight(size);
            Imagelist[i].setX(x);
            Imagelist[i].setY(y);
            Imagelist[i].setRotate(rotation);
            int finalI = i;
            flashTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration * i),
                    evt -> {
                        FlashSet.getChildren().addAll(Imagelist[finalI]);
                        pane.getChildren().add(Imagelist[finalI]);
                        pane.getChildren().remove(Imagelist[finalI - 1]);
                    }
            ));

        }
        flashTimeline.setOnFinished(actionEvent -> {
            pane.getChildren().remove(Imagelist[(choice) * 5 - 1]);
        });
        flashTimeline.play();
    }
}
