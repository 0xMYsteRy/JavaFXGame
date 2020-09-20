package Tank_JAVA;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.awt.*;
import java.security.Key;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Random;

public class Boss {
    private int Health = 500;
    private String ImagePath = "file:src/PNG/tower_boss.png";
    private String ImagePath2 = "file:src/PNG/SpecTower2.png";
    private int x;
    private Group boss;
    private Pane pane;

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
        bossTowerW.setFitWidth(9 * x);
        bossTowerW.setFitHeight(9 * x);
        ImageView bossTurretW = new ImageView(new Image(ImagePath2));
        bossTurretW.setFitWidth(9 * x);
        bossTurretW.setFitHeight(9 * x);
        boss.getChildren().addAll(bossTowerW, bossTurretW);
        return boss;
    }

    FireBall fireBall;
    double angle;
    Random random = new Random();

    public void Shooting(Pane pane, Tank tank) {
        this.pane = pane;
        Timeline BossShoot1 = new Timeline();
        angle = boss.getRotate();
        BossShoot1.getKeyFrames().add(new KeyFrame(Duration.millis(200 * random.nextInt(3) + 1),
                actionEvent -> {
                    angle = angle + 30;
                    System.out.println(2222);
                    fireBall = new FireBall(random.nextInt(6) + 1);
                    fireBall.FireBallAnimation(boss.getTranslateX() + 2 * x, boss.getTranslateY() + 2 * x, angle, 140, pane, tank);
                }));
        BossShoot1.setOnFinished(actionEvent -> {
            RotateTransition rT = new RotateTransition();
            rT.setNode(boss);
            rT.setDuration(Duration.millis(500));
            rT.setByAngle(180);
            rT.play();
        });
        BossShoot1.setCycleCount(12 * (random.nextInt(3) + 1));
        Timeline BossShoot2 = new Timeline();
        //
        BossShoot2.getKeyFrames().add(new KeyFrame(Duration.millis(1000),
                actionEvent -> {
                    for (int i = 1; i < 8; i++) {
                        angle = angle + 15 * i;
                        System.out.println(2222);
                        fireBall = new FireBall(random.nextInt(6) + 1);
                        fireBall.FireBallAnimation(boss.getTranslateX() + 2 * x, boss.getTranslateY() + 2 * x, angle, 140, pane, tank);
                    }
                }));
        BossShoot2.setOnFinished(actionEvent -> {
            RotateTransition rT = new RotateTransition();
            rT.setNode(boss);
            rT.setDuration(Duration.millis(500));
            rT.setByAngle(180);
            rT.setAutoReverse(true);
            rT.play();
        });
        BossShoot2.setCycleCount(3);
        BossShoot1.setDelay(Duration.millis(1000));
        Timeline playShootBoss = new Timeline();
        playShootBoss.getKeyFrames().add(new KeyFrame(Duration.millis(5000),
                actionEvent -> {
                    if (random.nextInt(2) + 1 == 1) {
                        BossShoot1.play();
                    } else if (random.nextInt(2) + 1 == 2) {
                        BossShoot2.play();
                    }
                }));
        playShootBoss.setCycleCount(Animation.INDEFINITE);
        playShootBoss.setOnFinished(actionEvent -> {
            if (!checkHealth()){
                playShootBoss.stop();
            }
        });
        playShootBoss.play();
    }

    public void setHealth(int damage) {
        Health -= damage;
        Text dam = new Text("-" + damage);
        dam.setFill(Color.RED);
        dam.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, 15));
        dam.setStroke(Color.WHITESMOKE);
        dam.setStrokeWidth(0.5);
        double iniX = boss.getTranslateX() + random.nextInt(10 + 10) + 17, iniY = boss.getTranslateY() + random.nextInt(10 + 10) + 5;
        dam.setX(iniX);
        dam.setY(iniY);
        pane.getChildren().add(dam);
        Timeline minusHealth = new Timeline(new KeyFrame(Duration.millis(50),
                actionEvent -> {
                    if (iniX > boss.getTranslateX() + 25) {
                        dam.setX(dam.getX() + 1);
                        dam.setY(dam.getY() - 5);
                    } else {
                        dam.setX(dam.getX() - 1);
                        dam.setY(dam.getY() - 5);
                    }
                    dam.setOpacity(dam.getOpacity() - 0.1);
                }));
        minusHealth.setCycleCount(20);
        minusHealth.setOnFinished(evt -> pane.getChildren().remove(dam));
        minusHealth.play();
    }

    //////////////
    private Explosion explosion = new Explosion();
    private int scale = 7;

    public boolean checkHealth() {
        if (Health <= 0) {
            System.out.println(Health);
            Timeline Bossdying = new Timeline(new KeyFrame(Duration.millis(100),
                    ac -> {
                        boss.setTranslateX(boss.getTranslateX() + 10);
                    }), new KeyFrame(Duration.millis(200), ac -> {
                boss.setTranslateX(boss.getTranslateX() + 10);
            }), new KeyFrame(Duration.millis(300), ac -> {
                boss.setTranslateX(boss.getTranslateX() - 10);
            }), new KeyFrame(Duration.millis(400), ac -> {
                boss.setTranslateX(boss.getTranslateX() - 10);
            }), new KeyFrame(Duration.millis(500), ac -> {
                boss.setTranslateX(boss.getTranslateX() - 10);
            }), new KeyFrame(Duration.millis(600), ac -> {
                boss.setTranslateX(boss.getTranslateX() - 10);
            }), new KeyFrame(Duration.millis(700), ac -> {
                boss.setTranslateX(boss.getTranslateX() + 10);
            }), new KeyFrame(Duration.millis(800), ac -> {
                boss.setTranslateX(boss.getTranslateX() + 10);
            })
            );
            Bossdying.setCycleCount(10);
            Bossdying.setOnFinished(evt -> {
                explosion.ExplosionAnimation(boss.getTranslateX() + scale * 2 * 5, boss.getTranslateY() + scale * 2 * 5, pane, 2);
                pane.getChildren().remove(boss);
            });
            Bossdying.play();
            return false;
        } else {
            return true;
        }
    }
}
