package Tank_JAVA;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class Bot {
    private Group bot;
    private Hull hull;
    private Bullet bullet;
    private Weapon weapon;
    private Track track;
    private RotateTransition rt;
    private FadeTransition ft, ft2;
    private Scene scene;
    private Pane botPane;
    // Stat of resolution
    double scale = 70 / 10.0;
    double gap = (70 - 9 * scale) / 2.0;
    double Step = 35;
    // Stat of bot
    private int bulletMode = 1;
    private double speed = 0;
    //Getter and setter methods, incase usefull to call those property from other classes.
    // Finish calling setter and getter methods
    private ArrayList<Rectangle> RectList;
    private ArrayList<ImageView> ObjList;
    Random random = new Random();

    // Constructor
    public Bot(int color, int choice, int typebot, double difficulty) {

        hull = new Hull(color, choice);
        weapon = new Weapon(color, choice);
        track = new Track(choice);
        this.bullet = new Bullet(choice);
    }

    private boolean Moving = false, Living = true;

    public void spawnbot(int x, int y, Pane botPane, Scene scene, ArrayList<Rectangle> rectList, ArrayList<ImageView> objList) {
        this.ObjList = objList;
        this.RectList = rectList;
        this.botPane = botPane;
        this.scene = scene;
        //

        //
        bot = createbot(scale);
        botPane.getChildren().addAll(bot);
        bot.setTranslateX(x + gap);
        bot.setTranslateY(y + gap);
        bot.setCache(true);
        //Displaying the contents of the stage
        bot.setRotate(0);
        //
        rt = new RotateTransition(Duration.millis(300), bot);
//        while (Living) {
        for (int i = 0; i < 1; i++) {
            int direction = random.nextInt(3)+1;
            int tankMoves = random.nextInt(3)+1;

            if ((bot.getTranslateX() - gap) % Step == 0 & (bot.getTranslateY() - gap) % Step == 0 & !Moving) {
                Timeline timelineBotshoot = new Timeline(new KeyFrame(Duration.millis(stepDuration*Step*2*tankMoves),
                        evt -> {
                            botmove(random.nextInt(4)+1,tankMoves);
                        }));
                timelineBotshoot.setCycleCount(Animation.INDEFINITE);
                timelineBotshoot.play();
            }
            if (bot.getRotate() == 0 | bot.getRotate() == 90 | bot.getRotate() == 180 | bot.getRotate() == 270) {
                KeyFrame[] keyFrame;
                Timeline timelineBotshoot = new Timeline(new KeyFrame(Duration.millis(1000),
                        evt -> {
//                            botshoot();
                        }));
                timelineBotshoot.setCycleCount(Animation.INDEFINITE);
                timelineBotshoot.play();
            }
        }
    }

    public Group createbot(double x) {
        Image weaponI = new Image(weapon.getWeapon());
        Image HullI = new Image(hull.getHull());
        Image trackI_A = new Image(track.getTrack());

        Rectangle rect = new Rectangle();
        rect.setHeight(x * 9);
        rect.setWidth(x * 9);
        rect.setFill(Color.rgb(10, 10, 10, 0));

        rect.setStroke(Paint.valueOf("green"));
        ImageView botView = new ImageView(HullI);
        ImageView TrackViewA1 = new ImageView(trackI_A);
        ImageView TrackViewA2 = new ImageView(trackI_A);
        ImageView TrackViewA3 = new ImageView(trackI_A);
        ImageView TrackViewA4 = new ImageView(trackI_A);
        ImageView WeaponView = new ImageView(weaponI);

        TrackViewA1.setX(2.2 * x);
        TrackViewA1.setY(0.2 * x);
        TrackViewA1.setFitHeight(4 * x);
        TrackViewA1.setFitWidth(1.3 * x);
        TrackViewA2.setX(2 * x);
        TrackViewA2.setY(5 * x);
        TrackViewA2.setFitHeight(4 * x);
        TrackViewA2.setFitWidth(1.5 * x);

        TrackViewA3.setX(5.5 * x);
        TrackViewA3.setY(0.2 * x);
        TrackViewA3.setFitHeight(4 * x);
        TrackViewA3.setFitWidth(1.3 * x);
        TrackViewA4.setX(5.5 * x);
        TrackViewA4.setY(5 * x);
        TrackViewA4.setFitHeight(4 * x);
        TrackViewA4.setFitWidth(1.5 * x);

        botView.setX(1.25 * x);
        botView.setY(0.5 * x);
        botView.setFitHeight(8 * x);
        botView.setFitWidth(6.5 * x);

        WeaponView.setX(3 * x);
        WeaponView.setFitHeight(7 * x);
        WeaponView.setFitWidth(3 * x);
        ColorAdjust grayscale = new ColorAdjust();

        grayscale.setContrast(0.5);

        Group root = new Group(TrackViewA1, TrackViewA2, TrackViewA3, TrackViewA4, botView, WeaponView);
        //Creating a scene object
        root.setEffect(grayscale);
        return root;
    }

    private int check = 0;
    private Timeline timeLineMovebot;
    private KeyFrame kf;
    double prevX, prevY;
    int moveStep;
    double stepDuration = (500 - 50 * (speed / 10.0 - 1)) / (70 / Step * 35);
    public void botmove(int direction,int moves) {
        Moving = true;
        check = 0;
        Random random = new Random();
        moveStep = moves;
        stepDuration = (500 - 50 * (speed / 10.0 - 1)) / (70 / Step * 35);
        // Testing
        System.out.println("I was here " + bot.getTranslateX()+" "+bot.getTranslateY());

        switch (direction) {
            case 1:
                if (bot.getRotate() != 0) {
                    rt.setByAngle(0 - bot.getRotate());
                    rt.setCycleCount(1);
                    rt.setAutoReverse(true);
                    rt.play();
                }
                KeyFrame stepKeyframe = new KeyFrame(
                        Duration.millis(stepDuration * Step),
                        actionEvent -> {
                            prevX = bot.getTranslateX();
                            prevY = bot.getTranslateY();
                            System.out.println(bot.getTranslateX()+" "+bot.getTranslateY());
                            kf = new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {

                                        for (Rectangle rectW : RectList) {
                                            if (bot.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                        }
                                        for (ImageView imgW : ObjList) {
                                            if (bot.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                        }
                                        if (check == 0) {
                                            bot.setTranslateY(bot.getTranslateY() - Step * 2 / 70.0);
                                        }
                                    }
                            );
                            timeLineMovebot = new Timeline(kf);
                            timeLineMovebot.setOnFinished(evt -> {
                                if (check == 1 | ((bot.getTranslateX() - gap) % Step != 0 & (bot.getTranslateY() % Step - gap) != 0)) {
                                    System.out.println(bot.getTranslateX());
                                    bot.setTranslateX(prevX);
                                    bot.setTranslateY(prevY);
                                }
                            });
                            timeLineMovebot.setCycleCount(35);
                            callPathTrack(bot.getTranslateX(), bot.getTranslateY(), bot.getRotate());
                            ft.play();
                            ft2.play();
                            timeLineMovebot.play();
                        }
                );
                Timeline timelineStep = new Timeline(stepKeyframe);
                timelineStep.setCycleCount(moveStep);
                timelineStep.play();
                break;
            case 2:
                if (bot.getRotate() != 90) {
                    rt.setByAngle(90 - bot.getRotate());
                    rt.setCycleCount(1);
                    rt.setAutoReverse(true);
                    rt.play();
                }
                stepKeyframe = new KeyFrame(
                        Duration.millis(stepDuration * Step),
                        actionEvent -> {
                            prevX = bot.getTranslateX();
                            prevY = bot.getTranslateY();
                            kf = new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {

                                        for (Rectangle rectW : RectList) {
                                            if (bot.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                        }
                                        for (ImageView imgW : ObjList) {
                                            if (bot.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                        }
                                        if (check == 0) {
                                            bot.setTranslateX(bot.getTranslateX() + Step * 2 / 70.0);
                                        }
                                    }
                            );
                            timeLineMovebot = new Timeline(kf);
                            timeLineMovebot.setOnFinished(evt -> {
                                if (check == 1 | ((bot.getTranslateX() - gap) % Step != 0 & (bot.getTranslateY() % Step - gap) != 0)) {
                                    bot.setTranslateX(prevX);
                                    bot.setTranslateY(prevY);
                                }
                            });
                            timeLineMovebot.setCycleCount(35);
                            callPathTrack(bot.getTranslateX(), bot.getTranslateY(), bot.getRotate());
                            ft.play();
                            ft2.play();
                            timeLineMovebot.play();
                        }
                );
                timelineStep = new Timeline(stepKeyframe);
                timelineStep.setCycleCount(moveStep);
                timelineStep.play();
                break;
            default:
                System.out.println("I was here!D " + direction);
                break;
            case 3:
                if (bot.getRotate() != 180) {
                    rt.setByAngle(180 - bot.getRotate());
                    rt.setCycleCount(1);
                    rt.setAutoReverse(true);
                    rt.play();

                }
                stepKeyframe = new KeyFrame(
                        Duration.millis(stepDuration * Step),
                        actionEvent -> {
                            prevX = bot.getTranslateX();
                            prevY = bot.getTranslateY();
                            kf = new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {
                                        if (check == 0) {
                                            for (Rectangle rectV : RectList) {
                                                if (bot.getBoundsInParent().intersects(rectV.getBoundsInParent())) {
                                                    check = 1;
                                                    break;
                                                }
                                            }
                                            for (ImageView imgW : ObjList) {
                                                if (bot.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                    check = 1;
                                                    break;
                                                }
                                            }
                                        }
                                        if (check == 0) {
                                            bot.setTranslateY(bot.getTranslateY() + Step * 2 / 70.0);
                                        }
                                    }
                            );
                            timeLineMovebot = new Timeline(kf);
                            timeLineMovebot.setOnFinished(evt -> {
                                if (check == 1 | ((bot.getTranslateX() - gap) % Step != 0 & (bot.getTranslateY() % Step - gap) != 0)) {
                                    System.out.println(bot.getTranslateX());
                                    bot.setTranslateX(prevX);
                                    bot.setTranslateY(prevY);
                                }
                            });
                            timeLineMovebot.setCycleCount(35);
                            callPathTrack(bot.getTranslateX(), bot.getTranslateY(), bot.getRotate());
                            ft.play();
                            ft2.play();
                            timeLineMovebot.play();
                        }
                );
                timelineStep = new Timeline(stepKeyframe);
                timelineStep.setCycleCount(moveStep);
                timelineStep.play();
                break;
            case 4:
                if (bot.getRotate() != 270) {
                    rt.setByAngle(270 - bot.getRotate());
                    rt.setCycleCount(1);
                    rt.setAutoReverse(true);
                    rt.play();

                }
                stepKeyframe = new KeyFrame(
                        Duration.millis(stepDuration * Step),
                        actionEvent -> {
                            prevX = bot.getTranslateX();
                            prevY = bot.getTranslateY();
                            kf = new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {

                                        for (Rectangle rectW : RectList) {
                                            if (bot.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                        }
                                        for (ImageView imgW : ObjList) {
                                            if (bot.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                        }
                                        if (check == 0) {
                                            bot.setTranslateX(bot.getTranslateX() - Step * 2 / 70.0);
                                        }
                                    }
                            );
                            timeLineMovebot = new Timeline(kf);
                            timeLineMovebot.setOnFinished(evt -> {
                                if (check == 1 | ((bot.getTranslateX() - gap) % Step != 0 & (bot.getTranslateY() % Step - gap) != 0)) {
                                    bot.setTranslateX(prevX);
                                    bot.setTranslateY(prevY);
                                }
                            });
                            timeLineMovebot.setCycleCount(35);
                            callPathTrack(bot.getTranslateX(), bot.getTranslateY(), bot.getRotate());
                            ft.play();
                            ft2.play();
                            timeLineMovebot.play();

                        }
                );
                timelineStep = new Timeline(stepKeyframe);
                timelineStep.setCycleCount(moveStep);
                timelineStep.play();
                break;
        }
        Moving= false;
    }

    private boolean shotBullet;
    private Explosion explosion;

    public void botshoot() {

        Flash flash = new Flash();
        double x;
        double y;
        double Direction = bot.getRotate();
        int Range = 10;
        int Speed = bullet.getSpeed() / 10 * Range;
        ImageView BulletW = new ImageView(new Image(bullet.getBullet(bulletMode)));
        BulletW.setFitWidth(scale * 9);
        BulletW.setFitHeight(scale * 9);
        BulletW.setRotate(Direction);
        // Timeline
        double steps = scale * Range * 4 / 2.0;
        double stepDuration = 100 * Speed / steps;
        Timeline bulletAnimation;
        switch ((int) Direction) {
            case 0:
                x = bot.getTranslateX();
                y = bot.getTranslateY() - scale * 4.0;
                flash.FlashAnimation(x, y - scale * 4.0, BulletW.getRotate(), BulletW.getFitWidth(), bulletMode, botPane);
                bulletAnimation = new Timeline(
                        new KeyFrame(
                                Duration.millis(stepDuration),
                                (evt) -> {
                                    int check = 0;
                                    if ((BulletW.getTranslateY() % 70) % 36 == 0 & BulletW.getTranslateY() % 70 != 0 & !shotBullet) {
                                        for (Rectangle rectW : RectList) {
                                            if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                        }
                                        for (ImageView imgW : ObjList) {
                                            if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                check = 1;
                                                botPane.getChildren().remove(imgW);
                                                explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), botPane);
                                                ObjList.remove(imgW);
                                                break;
                                            }
                                        }

                                    }
                                    if (check == 0) {
                                        BulletW.setTranslateY(BulletW.getTranslateY() - 2);
                                    } else {
                                        botPane.getChildren().remove(BulletW);
                                        shotBullet = true;
                                    }
                                }
                        ));
                bulletAnimation.setOnFinished(evt -> {
                    System.out.printf("Exploded at %f x - %f y\n", BulletW.getTranslateX(), BulletW.getTranslateY());
                    botPane.getChildren().remove(BulletW);
                });
                bulletAnimation.setCycleCount((int) steps);
                BulletW.setX(x);
                BulletW.setY(y);
                bulletAnimation.play();
                break;
            case 90:
                x = bot.getTranslateX() + scale * 4.0;
                y = bot.getTranslateY();
                flash.FlashAnimation(x + scale * 4.0, y, BulletW.getRotate(), BulletW.getFitWidth(), bulletMode, botPane);
                bulletAnimation = new Timeline(
                        new KeyFrame(
                                Duration.millis(stepDuration),
                                (evt) -> {
                                    int check = 0;
                                    if ((BulletW.getTranslateX() % 70) % 36 == 0 & BulletW.getTranslateX() % 70 != 0 & !shotBullet) {
                                        for (Rectangle rectW : RectList) {
                                            if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                        }
                                        for (ImageView imgW : ObjList) {
                                            if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                check = 1;
                                                botPane.getChildren().remove(imgW);
                                                explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), botPane);

                                                ObjList.remove(imgW);
                                                break;
                                            }
                                        }
                                    }

                                    if (check == 0) {
                                        BulletW.setTranslateX(BulletW.getTranslateX() + 2);
                                    } else {
                                        botPane.getChildren().remove(BulletW);
                                        shotBullet = true;
                                    }
                                }
                        ));
                bulletAnimation.setOnFinished(evt -> {
                    System.out.printf("Exploded at %f x - %f y\n", BulletW.getTranslateX(), BulletW.getTranslateY());
                    botPane.getChildren().remove(BulletW);
                });
                bulletAnimation.setCycleCount((int) steps);
                BulletW.setX(x);
                BulletW.setY(y);
                bulletAnimation.play();
                break;
            case 180:
                x = bot.getTranslateX();
                y = bot.getTranslateY() + scale * 4.0;
                flash.FlashAnimation(x, y + scale * 4.0, BulletW.getRotate(), BulletW.getFitWidth(), bulletMode, botPane);
                bulletAnimation = new Timeline(
                        new KeyFrame(
                                Duration.millis(stepDuration),
                                (evt) -> {
                                    int check = 0;
                                    if ((BulletW.getTranslateY() % 70) % 36 == 0 & BulletW.getTranslateY() % 70 != 0 & !shotBullet) {
                                        for (Rectangle rectW : RectList) {
                                            if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                            for (ImageView imgW : ObjList) {
                                                if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                    check = 1;
                                                    botPane.getChildren().remove(imgW);
                                                    explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), botPane);

                                                    ObjList.remove(imgW);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if (check == 0) {
                                        BulletW.setTranslateY(BulletW.getTranslateY() + 2);
                                    } else {
                                        botPane.getChildren().remove(BulletW);
                                        shotBullet = true;
                                    }
                                }
                        ));
                bulletAnimation.setOnFinished(evt -> {
                    System.out.printf("Exploded at %f x - %f y\n", BulletW.getTranslateX(), BulletW.getTranslateY());
                    botPane.getChildren().remove(BulletW);
                });
                bulletAnimation.setCycleCount((int) steps);
                BulletW.setX(x);
                BulletW.setY(y);
                bulletAnimation.play();
                break;
            case 270:
                x = bot.getTranslateX() - scale * 4.0;
                y = bot.getTranslateY();
                flash.FlashAnimation(x - scale * 4.0, y, BulletW.getRotate(), BulletW.getFitWidth(), bulletMode, botPane);
                bulletAnimation = new Timeline(
                        new KeyFrame(
                                Duration.millis(stepDuration),
                                (evt) -> {
                                    int check = 0;
                                    if ((BulletW.getTranslateX() % 70) % 36 == 0 & BulletW.getTranslateX() % 70 != 0 & !shotBullet) {
                                        for (Rectangle rectW : RectList) {
                                            if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                            for (ImageView imgW : ObjList) {
                                                if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                    check = 1;
                                                    botPane.getChildren().remove(imgW);
                                                    explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), botPane);
                                                    ObjList.remove(imgW);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if (check == 0) {
                                        BulletW.setTranslateX(BulletW.getTranslateX() - 2);
                                    } else {
                                        botPane.getChildren().remove(BulletW);
                                        shotBullet = true;
                                    }
                                }
                        ));
                bulletAnimation.setOnFinished(evt -> {
                    System.out.printf("Exploded at %f x - %f y\n", BulletW.getTranslateX(), BulletW.getTranslateY());
                    botPane.getChildren().remove(BulletW);
                });

                bulletAnimation.setCycleCount((int) steps);
                BulletW.setX(x);
                BulletW.setY(y);
                bulletAnimation.play();

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + (int) Direction);
        }
        botPane.getChildren().addAll(BulletW);
    }

    public void callPathTrack(double x, double y, double direction) {
        var ptr = new TranslateTransition();
        ptr.setDuration(Duration.millis((500 - 50 * (speed / 10.0 - 1)) / (70 / Step)));
        // (500 - 50 * (speed / 10.0 - 1)) / (  70/Step  *35.0)
        ptr.setCycleCount(1);

        var ptr2 = new TranslateTransition();
        ptr2.setDuration(Duration.millis((500 - 50 * (speed / 10.0 - 1)) / (70 / Step)));
        ptr2.setCycleCount(1);

        track = new Track(1);
        ImageView pathTrack = new ImageView(new Image(track.getTrackPath(2)));
        pathTrack.setFitHeight(50 * scale / 10.0);
        pathTrack.setFitWidth(50 * scale / 10.0);
        pathTrack.setRotate(bot.getRotate());
        ImageView pathTrack2 = new ImageView(new Image(track.getTrackPath(2)));
        pathTrack2.setFitHeight(50 * scale / 10.0);
        pathTrack2.setFitWidth(50 * scale / 10.0);
        pathTrack2.setRotate(bot.getRotate());
        botPane.getChildren().addAll(pathTrack, pathTrack2);
        switch ((int) direction) {
            case 0:

                pathTrack.setX(x + 39 * scale / 10.0);
                pathTrack.setY(y + 70 * scale / 10.0 + gap);
                pathTrack2.setX(x + 2 * scale / 10.0);
                pathTrack2.setY(y + 70 * scale / 10.0 + gap);
                ptr.setNode(pathTrack);
                ptr.setToX(0);
                ptr.setToY(-Step);
                ptr2.setNode(pathTrack2);
                ptr2.setToX(0);
                ptr2.setToY(-Step);
                break;
            case 90:
                pathTrack.setX(x - 35 * scale / 10.0 - gap);
                pathTrack.setY(y + 39 * scale / 10.0);
                pathTrack2.setX(x - 35 * scale / 10.0 - gap);
                pathTrack2.setY(y + 2 * scale / 10.0);
                ptr.setNode(pathTrack);
                ptr.setToX(Step);
                ptr.setToY(0);
                ptr2.setNode(pathTrack2);
                ptr2.setToX(Step);
                ptr2.setToY(0);
                break;
            case 180:
                pathTrack.setX(x + 38 * scale / 10.0);
                pathTrack.setY(y - 35 * scale / 10.0 - gap);
                pathTrack2.setX(x + 2 * scale / 10.0);
                pathTrack2.setY(y - 35 * scale / 10.0 - gap);
                ptr.setNode(pathTrack);
                ptr.setToX(0);
                ptr.setToY(Step);
                ptr2.setNode(pathTrack2);
                ptr2.setToX(0);
                ptr2.setToY(Step);
                break;
            case 270:
                pathTrack.setX(x + 70 * scale / 10.0 + gap);
                pathTrack.setY(y + 37 * scale / 10.0);
                pathTrack2.setX(x + 70 * scale / 10.0 + gap);
                pathTrack2.setY(y + 2 * scale / 10.0);
                ptr.setNode(pathTrack);
                ptr.setToX(-Step);
                ptr.setToY(0);
                ptr2.setNode(pathTrack2);
                ptr2.setToX(-Step);
                ptr2.setToY(0);
                break;
        }

        ft = new FadeTransition(Duration.millis((800 - 50 * (speed / 10.0 - 1))), pathTrack);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft2 = new FadeTransition(Duration.millis((800 - 50 * (speed / 10.0 - 1))), pathTrack2);
        ft2.setFromValue(1.0);
        ft2.setToValue(0);
        ptr.play();
        ptr2.play();
    }

}
