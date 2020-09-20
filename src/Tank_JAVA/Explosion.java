package Tank_JAVA;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.Serializable;

public class Explosion implements Serializable {
    private ImageView a1 = new ImageView(new Image("file:src/PNG/Effects/Explosion_A.png"));
    private ImageView a2 = new ImageView(new Image("file:src/PNG/Effects/Explosion_B.png"));
    private ImageView a3 = new ImageView(new Image("file:src/PNG/Effects/Explosion_C.png"));
    private ImageView a4 = new ImageView(new Image("file:src/PNG/Effects/Explosion_D.png"));
    private ImageView a5 = new ImageView(new Image("file:src/PNG/Effects/Explosion_E.png"));
    private ImageView a6 = new ImageView(new Image("file:src/PNG/Effects/Explosion_F.png"));
    private ImageView a7 = new ImageView(new Image("file:src/PNG/Effects/Explosion_G.png"));
    private ImageView a8 = new ImageView(new Image("file:src/PNG/Effects/Explosion_H.png"));
    private double duration = 50;

    public Explosion() {
    }

    public void ExplosionAnimation(double x, double y, Pane tankPane, int scale) {
        a1.setFitWidth(70*scale);
        a1.setFitHeight(70*scale);
        a2.setFitWidth(70*scale);
        a2.setFitHeight(70*scale);
        a3.setFitWidth(70*scale);
        a3.setFitHeight(70*scale);
        a4.setFitWidth(70*scale);
        a4.setFitHeight(70*scale);
        a5.setFitWidth(70*scale);
        a5.setFitHeight(70*scale);
        a6.setFitWidth(70*scale);
        a6.setFitHeight(70*scale);
        a7.setFitWidth(70*scale);
        a7.setFitHeight(70*scale);
        a8.setFitWidth(70*scale);
        a8.setFitHeight(70*scale);
        a1.setX(x);
        a1.setY(y);
        a2.setX(x);
        a2.setY(y);
        a3.setX(x);
        a3.setY(y);
        a4.setX(x);
        a4.setY(y);
        a5.setX(x);
        a5.setY(y);
        a6.setX(x);
        a6.setY(y);
        a7.setX(x);
        a7.setY(y);
        a8.setX(x);
        a8.setY(y);
        Group ExplosionSet = new Group(a1);
        Timeline exploTimeline = new Timeline();
        tankPane.getChildren().addAll(a1);
        exploTimeline.setCycleCount(1);
        exploTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration),
                evt -> {
                    ExplosionSet.getChildren().addAll(a2);
                    tankPane.getChildren().addAll(a2);
                }
        ));
        exploTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration * 2),
                evt -> {
                    ExplosionSet.getChildren().addAll(a3);
                    tankPane.getChildren().addAll(a3);
                }
        ));
        exploTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration * 3),
                evt -> {
                    ExplosionSet.getChildren().addAll(a4);
                    tankPane.getChildren().addAll(a4);
                }
        ));
        exploTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration * 4),
                evt -> {
                    ExplosionSet.getChildren().addAll(a5);
                    tankPane.getChildren().addAll(a5);
                }
        ));
        exploTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration * 5),
                evt -> {
                    ExplosionSet.getChildren().addAll(a6);
                    tankPane.getChildren().addAll(a6);
                }
        ));
        exploTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration * 6),
                evt -> {
                    ExplosionSet.getChildren().addAll(a7);
                    tankPane.getChildren().addAll(a7);
                }
        ));
        exploTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration * 7),
                evt -> {
                    ExplosionSet.getChildren().addAll(a8);
                    tankPane.getChildren().addAll(a8);
                }
        ));
        exploTimeline.setOnFinished(evt -> {
            tankPane.getChildren().removeAll(a1, a2, a3, a4, a5, a6, a7, a8);
        });
        exploTimeline.play();
    }
}
