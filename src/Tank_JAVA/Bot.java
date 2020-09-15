package Tank_JAVA;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class Bot implements Runnable {
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
    private int bulletMode = 2;
    private double speed = 0;
    //Getter and setter methods, incase usefull to call those property from other classes.
    // Finish calling setter and getter methods
    private ArrayList<Rectangle> RectList;
    private ArrayList<ImageView> ObjList;
    Random random = new Random();
    private int spawnx, spawny;
    private int difficulty;
    private Tank playerTank;

    // Constructor
    public Bot(int x, int y, int color, int choice, int typebot, int difficulty) {
        this.difficulty = difficulty;
        this.spawnx = x;
        this.spawny = y;
        hull = new Hull(color, choice);
        weapon = new Weapon(color, choice);
        track = new Track(choice);
        this.bullet = new Bullet(choice);
    }

    private boolean Moving = false, Living = true, Rotating = false;

    public Group getBot() {
        return bot;
    }

    public void setLiving(boolean Living) {
        this.Living = Living;
        timelineBotMove.stop();
        timelineBotshoot.stop();
    }

    Timeline timelineBotMove;
    Timeline timelineBotshoot;

    @Override
    public void run() {

    }

    public void spawnbot(Pane botPane, Scene scene, ArrayList<Rectangle> rectList, ArrayList<ImageView> objList, Tank tank) {
        this.ObjList = objList;
        this.RectList = rectList;
        this.botPane = botPane;
        this.scene = scene;
        this.playerTank = tank;
        //
        bot = createbot(scale);
        botPane.getChildren().addAll(bot);
        bot.setTranslateX(spawnx + gap);
        bot.setTranslateY(spawny + gap);
        bot.setCache(true);
        //Displaying the contents of the stage
        bot.setRotate(0);
        //
        rt = new RotateTransition(Duration.millis(100), bot);
//        while (Living)
//         {
        int tankMoves = random.nextInt(5) + 1;

        timelineBotMove = new Timeline(new KeyFrame(Duration.millis(stepDuration * Step * 3 * tankMoves),
                evt -> {
                    if ((bot.getTranslateX() - gap) % Step == 0 & (bot.getTranslateY() - gap) % Step == 0 & !Moving & !Rotating) {

                        botmove(random.nextInt(4) + 1, tankMoves);
                    }
                }));
        timelineBotMove.setOnFinished(actionEvent -> {
            if (Living) {
                timelineBotMove.play();
            }
        });
        timelineBotMove.setCycleCount(Animation.INDEFINITE);
        timelineBotMove.play();
        timelineBotshoot = new Timeline(new KeyFrame(Duration.millis(1200.0 / difficulty),
                evt -> {
                    botshoot();
                }));
        timelineBotMove.setOnFinished(actionEvent -> {
            if (Living) {
                timelineBotshoot.play();
            }
        });
        timelineBotshoot.setCycleCount(Animation.INDEFINITE);
        timelineBotshoot.play();

//        }
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
    int moveStep;
    double stepDuration = (500 - 50 * (speed / 10.0 - 1)) / (70 / Step * 35);

    public void botmove(int direction, int moves) {
        Moving = true;
        Rotating = true;
        check = 0;
        Random random = new Random();
        moveStep = moves;
        stepDuration = (500 - 50 * (speed / 10.0 - 1)) / (70 / Step * 35);
        // Testing

        switch (direction) {
            case 1:
                if (bot.getRotate() != 0) {
                    rt.setByAngle(0 - bot.getRotate());
                    rt.setCycleCount(1);
                    rt.setAutoReverse(true);
                    rt.setOnFinished(actionEvent -> Rotating = false);
                    rt.play();
                }
                KeyFrame stepKeyframe = new KeyFrame(
                        Duration.millis(stepDuration * Step),
                        actionEvent -> {
                            AtomicReference<Double> prevY = new AtomicReference<>((double) 0);
                            kf = new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {
                                        for (Rectangle rectW : RectList) {
                                            if (bot.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                        }
                                        if (bot.getBoundsInParent().intersects(playerTank.getTank().getBoundsInParent())) {
                                            check = 1;
                                        }
                                        for (ImageView imgW : ObjList) {
                                            if (bot.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                check = 1;
                                                break;
                                            }
                                        }
                                        if (bot.getTranslateX() <= 0 | bot.getTranslateY() >= 770 | bot.getTranslateY() <= 0 | bot.getTranslateX() >= 1365) {
                                            check = 1;
                                        }
                                        if (check == 0) {
                                            bot.setTranslateY(bot.getTranslateY() - Step * 2 / 70.0);
                                            prevY.updateAndGet(v -> (double) (v - Step * 2 / 70.0));
                                        }
                                    }
                            );
                            timeLineMovebot = new Timeline(kf);
                            timeLineMovebot.setOnFinished(evt -> {
                                if (check == 1) {
                                    bot.setTranslateY(bot.getTranslateY() - prevY.get());
                                    check = 0;
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
                    rt.setOnFinished(actionEvent -> Rotating = false);

                    rt.setAutoReverse(true);
                    rt.play();
                }
                stepKeyframe = new KeyFrame(
                        Duration.millis(stepDuration * Step),
                        actionEvent -> {
                            AtomicReference<Double> prevX = new AtomicReference<>((double) 0);
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
                                        if (bot.getBoundsInParent().intersects(playerTank.getTank().getBoundsInParent())) {
                                            check = 1;
                                        }
                                        if (bot.getTranslateX() <= 0 | bot.getTranslateY() >= 770 | bot.getTranslateY() <= 0 | bot.getTranslateX() >= 1365) {
                                            check = 1;
                                        }
                                        if (check == 0) {

                                            bot.setTranslateX(bot.getTranslateX() + Step * 2 / 70.0);
                                            prevX.updateAndGet(v -> (double) (v + Step * 2 / 70.0));
                                        }
                                    }
                            );
                            timeLineMovebot = new Timeline(kf);
                            timeLineMovebot.setOnFinished(evt -> {
                                if (check == 1) {
                                    bot.setTranslateX(bot.getTranslateX() - prevX.get());
                                    check = 0;
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
            case 3:
                if (bot.getRotate() != 180) {
                    rt.setByAngle(180 - bot.getRotate());
                    rt.setCycleCount(1);
                    rt.setOnFinished(actionEvent -> Rotating = false);

                    rt.setAutoReverse(true);
                    rt.play();

                }
                stepKeyframe = new KeyFrame(
                        Duration.millis(stepDuration * Step),
                        actionEvent -> {
                            AtomicReference<Double> prevY = new AtomicReference<>((double) 0);
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
                                        if (bot.getBoundsInParent().intersects(playerTank.getTank().getBoundsInParent())) {
                                            check = 1;
                                        }
                                        if (bot.getTranslateX() <= 0 | bot.getTranslateY() >= 770 | bot.getTranslateY() <= 0 | bot.getTranslateX() >= 1365) {
                                            check = 1;
                                        }
                                        if (check == 0) {
                                            bot.setTranslateY(bot.getTranslateY() + Step * 2 / 70.0);
                                            prevY.updateAndGet(v -> (double) (v + Step * 2 / 70.0));
                                        }
                                    }
                            );
                            timeLineMovebot = new Timeline(kf);
                            timeLineMovebot.setOnFinished(evt -> {
                                if (check == 1) {
                                    bot.setTranslateY(bot.getTranslateY() - prevY.get());
                                    check = 0;
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
                    rt.setOnFinished(actionEvent -> Rotating = false);
                    rt.setAutoReverse(true);
                    rt.play();

                }
                stepKeyframe = new KeyFrame(
                        Duration.millis(stepDuration * Step),
                        actionEvent -> {

                            AtomicReference<Double> prevX = new AtomicReference<>((double) 0);
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
                                        if (bot.getBoundsInParent().intersects(playerTank.getTank().getBoundsInParent())) {
                                            check = 1;
                                        }
                                        if (bot.getTranslateX() <= 0 | bot.getTranslateY() >= 770 | bot.getTranslateY() <= 0 | bot.getTranslateX() >= 1365) {
                                            check = 1;
                                        }
                                        if (check == 0) {
                                            bot.setTranslateX(bot.getTranslateX() - Step * 2 / 70.0);
                                            prevX.updateAndGet(v -> (double) (v - Step * 2 / 70.0));
                                        }
                                    }
                            );
                            timeLineMovebot = new Timeline(kf);
                            timeLineMovebot.setOnFinished(evt -> {
                                if (check == 1) {
                                    bot.setTranslateX(bot.getTranslateX() - prevX.get());
                                    check = 0;
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
                Moving = false;
                Rotating = false;
                break;
        }
        Moving = false;
        Rotating = false;
    }

    private boolean shotBullet;
    private Explosion explosion;
    double bulletSteps;
    int checkBullet = 0, shotPlayer = 0;
    double BulletstepDuration;

    public void botshoot() {
        checkBullet = 0;
        Flash flash = new Flash();
        explosion = new Explosion();
        double x;
        double y;
        double Direction = bot.getRotate();
        int Range = 10;
        int Speed = bullet.getSpeed() / 10 * Range;
        ImageView BulletW = new ImageView(new Image(bullet.getBullet(bulletMode)));
        BulletW.setFitWidth(scale * 9);
        BulletW.setFitHeight(scale * 9);
        BulletW.setRotate(Direction);
        botPane.getChildren().addAll(BulletW);
        // Timeline
        bulletSteps = scale * Range * 4 / 2.0;
        BulletstepDuration = 100 * Speed / bulletSteps;
        Timeline bulletAnimation;
        switch ((int) Direction) {
            case 0:
                x = bot.getTranslateX();
                y = bot.getTranslateY() - scale * 4.0;
                flash.FlashAnimation(x, y - scale * 4.0, BulletW.getRotate(), BulletW.getFitWidth(), bulletMode, botPane);
                bulletAnimation = new Timeline(
                        new KeyFrame(
                                Duration.millis(BulletstepDuration),
                                (evt) -> {
                                    if ((BulletW.getTranslateY() % 70) % 36 == 0 & BulletW.getTranslateY() % 70 != 0) {
                                        for (Rectangle rectW : RectList) {
                                            if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                checkBullet = 1;
                                                break;
                                            }
                                        }
                                        for (ImageView imgW : ObjList) {
                                            if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                checkBullet = 1;
                                                botPane.getChildren().remove(imgW);
                                                explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), botPane);
                                                ObjList.remove(imgW);
                                                break;
                                            }
                                        }
                                        if (BulletW.getBoundsInParent().intersects(playerTank.getTank().getBoundsInParent())) {
                                            shotPlayer = 1;
                                            checkBullet = 1;
                                            explosion.ExplosionAnimation(playerTank.getTank().getTranslateX(), playerTank.getTank().getTranslateY(), botPane);
                                        }
                                        ;

                                    }
                                    if (checkBullet == 0) {
                                        BulletW.setTranslateY(BulletW.getTranslateY() - 2);
                                    } else {
                                        botPane.getChildren().remove(BulletW);
                                    }
                                }
                        ));
                bulletAnimation.setOnFinished(evt -> {
                    botPane.getChildren().remove(BulletW);
                    if (shotPlayer == 1) {
                        playerTank.setHealth(bullet.getDamage());
                        shotPlayer = 0;
                    }
                });
                bulletAnimation.setCycleCount((int) bulletSteps);
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
                                Duration.millis(BulletstepDuration),
                                (evt) -> {

                                    if ((BulletW.getTranslateX() % 70) % 36 == 0 & BulletW.getTranslateX() % 70 != 0) {
                                        for (Rectangle rectW : RectList) {
                                            if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                checkBullet = 1;
                                                break;
                                            }
                                        }
                                        for (ImageView imgW : ObjList) {
                                            if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                checkBullet = 1;
                                                botPane.getChildren().remove(imgW);
                                                explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), botPane);

                                                ObjList.remove(imgW);
                                                break;
                                            }
                                        }
                                        if (BulletW.getBoundsInParent().intersects(playerTank.getTank().getBoundsInParent())) {
                                            shotPlayer = 1;
                                            checkBullet = 1;
                                            explosion.ExplosionAnimation(playerTank.getTank().getTranslateX(), playerTank.getTank().getTranslateY(), botPane);
                                        }

                                    }

                                    if (checkBullet == 0) {
                                        BulletW.setTranslateX(BulletW.getTranslateX() + 2);
                                    } else {
                                        botPane.getChildren().remove(BulletW);
                                    }
                                }
                        ));
                bulletAnimation.setOnFinished(evt -> {
                    botPane.getChildren().remove(BulletW);
                    if (shotPlayer == 1) {
                        playerTank.setHealth(bullet.getDamage());
                        shotPlayer = 0;
                    }
                });
                bulletAnimation.setCycleCount((int) bulletSteps);
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
                                Duration.millis(BulletstepDuration),
                                (evt) -> {
                                    if ((BulletW.getTranslateY() % 70) % 36 == 0 & BulletW.getTranslateY() % 70 != 0) {
                                        for (Rectangle rectW : RectList) {
                                            if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                checkBullet = 1;
                                                break;
                                            }
                                        }
                                        for (ImageView imgW : ObjList) {
                                            if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                checkBullet = 1;
                                                botPane.getChildren().remove(imgW);
                                                explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), botPane);

                                                ObjList.remove(imgW);
                                                break;
                                            }
                                        }
                                        if (BulletW.getBoundsInParent().intersects(playerTank.getTank().getBoundsInParent())) {
                                            shotPlayer = 1;
                                            checkBullet = 1;
                                            explosion.ExplosionAnimation(playerTank.getTank().getTranslateX(), playerTank.getTank().getTranslateY(), botPane);
                                        }

                                    }
                                    if (checkBullet == 0) {
                                        BulletW.setTranslateY(BulletW.getTranslateY() + 2);
                                    } else {
                                        botPane.getChildren().remove(BulletW);
                                    }
                                }
                        ));
                bulletAnimation.setOnFinished(evt -> {
                    botPane.getChildren().remove(BulletW);
                    if (shotPlayer == 1) {
                        playerTank.setHealth(bullet.getDamage());
                        shotPlayer = 0;
                    }
                });
                bulletAnimation.setCycleCount((int) bulletSteps);
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
                                Duration.millis(BulletstepDuration),
                                (evt) -> {
                                    if ((BulletW.getTranslateX() % 70) % 36 == 0 & BulletW.getTranslateX() % 70 != 0) {
                                        for (Rectangle rectW : RectList) {
                                            if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                checkBullet = 1;
                                                break;
                                            }
                                        }
                                        for (ImageView imgW : ObjList) {
                                            if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                checkBullet = 1;
                                                botPane.getChildren().remove(imgW);
                                                explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), botPane);
                                                ObjList.remove(imgW);
                                                break;
                                            }
                                        }
                                        if (BulletW.getBoundsInParent().intersects(playerTank.getTank().getBoundsInParent())) {
                                            shotPlayer = 1;
                                            checkBullet = 1;
                                            explosion.ExplosionAnimation(playerTank.getTank().getTranslateX(), playerTank.getTank().getTranslateY(), botPane);
                                        }

                                    }
                                    if (checkBullet == 0) {
                                        BulletW.setTranslateX(BulletW.getTranslateX() - 2);
                                    } else {
                                        botPane.getChildren().remove(BulletW);
                                    }
                                }
                        ));
                bulletAnimation.setOnFinished(evt -> {
                    botPane.getChildren().remove(BulletW);
                    if (shotPlayer == 1) {
                        playerTank.setHealth(bullet.getDamage());
                        shotPlayer = 0;
                    }
                });

                bulletAnimation.setCycleCount((int) bulletSteps);
                BulletW.setX(x);
                BulletW.setY(y);
                bulletAnimation.play();

                break;
            default:
                botPane.getChildren().remove(BulletW);
        }
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
