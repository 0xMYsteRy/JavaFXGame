package Tank_JAVA;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class FireBall {

    ImageView[] FBImageList = new ImageView[60];

    public FireBall(int choice) {
        for (int i = 0; i < 60; i++) {
            FBImageList[i] = new ImageView(new Image("file:src/Free pack 6" + "/" + choice + "/1_" + i + ".png"));
            FBImageList[i].setRotate(90);
            //src/FXpack13/Effect1/1.png
        }
    }

    boolean finished = true;
    ;

    public void FireBallAnimation(double x, double y, double rotation, double size, Pane pane, Tank tank) {
        if (finished) {
            Group FireBallSet = new Group(FBImageList[0]);
            Timeline FireBallTimeline = new Timeline();
            FireBallTimeline.setCycleCount(1);
            Explosion explosion= new Explosion();
            for (int i = 1; i < 60; i++) {
                FBImageList[i].setFitWidth(size);
                FBImageList[i].setFitHeight(size);
                FBImageList[i].setX(x+ i*(3*Math.tan(rotation)));
                FBImageList[i].setY(y - i * 3);
                FBImageList[i].setRotate(rotation);
                int finalI = i;
                FireBallTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000 / 60.0 * (i + 1)),
                        evt -> {
//                            if (FBImageList[finalI].getBoundsInParent().intersects(tank.getTank().getBoundsInParent())) {
//                                tank.setHealth(20);
//                                explosion.ExplosionAnimation(tank.getTank().getTranslateX(),tank.getTank().getTranslateY(),pane);
//                                finished=true;
//                            }
                            FireBallSet.getChildren().add(FBImageList[finalI]);
                            pane.getChildren().add(FBImageList[finalI]);
                            pane.getChildren().remove(FBImageList[finalI - 1]);
                        }
                ));
            }
            FireBallTimeline.setOnFinished(actionEvent -> {
                    for (int j = 0; j < 60; j++) {
                    pane.getChildren().remove(FBImageList[59]);
                    finished = true;
                }
            });
            FireBallTimeline.play();
        }
    }

    public void RemoveFireBallAnimation(Pane pane) {
//        FireBallTimeline.setCycleCount(1);
    }
}

