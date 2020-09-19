package Tank_JAVA;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.sql.Timestamp;
import java.util.Random;

public class Boss {
    private int health = 500;
    private String ImagePath = "file:src/PNG/tower_boss.png";
    private String ImagePath2 = "file:src/PNG/SpecTower2.png";
    private int x;
    private Group boss;

    public Boss(int x) {
        this.x = x;
    }

    public Group getBoss() {
        return boss;
    }

    public Group createBoss() {
        boss = new Group();
        Image img;
        ImageView bossTowerW = new ImageView(new Image(ImagePath));
        bossTowerW.setFitWidth(10 * x);
        bossTowerW.setFitHeight(10 * x);
        ImageView bossTurretW = new ImageView(new Image(ImagePath2));
        bossTurretW.setFitWidth(10 * x);
        bossTurretW.setFitHeight(10 * x);
        boss.getChildren().addAll(bossTowerW, bossTurretW);
        return boss;
    }

    FireBall fireBall;
    double angle;
    public void Shooting(Pane pane, Tank tank) {
        Random random = new Random();
        Timeline BossShoot1 = new Timeline();
        angle= boss.getRotate();
        BossShoot1.getKeyFrames().add(new KeyFrame(Duration.millis(1000),
                actionEvent -> {
                    angle=angle+ 30;
                    System.out.println(2222);
                    fireBall = new FireBall(2);
                    fireBall.FireBallAnimation(boss.getTranslateX()+5*x, boss.getTranslateY()+5*x,angle  , 140, pane, tank);
                }));
        BossShoot1.setOnFinished(actionEvent -> {
            RotateTransition rT = new RotateTransition();
            rT.setNode(boss);
            rT.setDuration(Duration.millis(500));
            rT.setByAngle(180);
            rT.play();
        });
        BossShoot1.setCycleCount(12);
//        BossShoot1.setDelay(Duration.millis(1000));
        BossShoot1.play();
    }
}
