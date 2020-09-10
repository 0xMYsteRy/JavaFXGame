package Tank_JAVA;

import Map_JAVA.Map;
import javafx.animation.*;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/*MAC: --module-path "/Users/s3757937/Downloads/javafx-sdk-11.0.2/lib" --add-modules javafx.controls,javafx.fxml*/
class Hull {
    private int color = 1;
    private int type;

    Hull(int Color, int Type) {
        this.color = Color;
        this.type = Type;
    }

    public String getHull() {
        String colorPath;
        switch (color) {
            case 1:
                colorPath = "A";
                break;
            case 2:
                colorPath = "B";
                break;
            case 3:
                colorPath = "C";
                break;
            case 4:
                colorPath = "D";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + color);
        }

        return "file:" + "src/PNG/Hulls_Color_" + colorPath + "/Hull_0" + type + ".png";
    }
}

class Weapon {
    private int color;
    private int Option;

    Weapon(int Color, int Option) {
        this.color = Color;
        this.Option = Option;
    }

    public String getWeapon() {
        String colorPath;
        switch (color) {
            case 1:
                colorPath = "A";
                break;
            case 2:
                colorPath = "B";
                break;
            case 3:
                colorPath = "C";
                break;
            case 4:
                colorPath = "D";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + color);
        }

        return "file:" + "src/PNG/Weapon_Color_" + colorPath + "/Gun_0" + Option + ".png";
    }
}

class Track {
    private final float duration = 1;
    private int Option;

    Track(int Option) {
        this.Option = (Option - 1) % 3 + 1;

    }

    public String getTrackPath(int TrackPathOption) {

        return "file:src/PNG/Effects/Tire_Track_0" + TrackPathOption + ".png";
    }

    public String getTrack() {
        return "file:src/PNG/Tracks/Track_" + Option + "_A.png";
    }
}

class Bullet {
    private int counting = 0;
    private int Damage = 0;
    private int Speed = 0;
    private int Effect = 0;
    private double RealoadRate = 0;
    private int Ammunition = 0;
    private int Range = 0;
    private String ImagePath = "file:src/SCML/Effects/Exhaust_Fire.png";
    private ImageView Bullet = new ImageView(new Image(ImagePath));

    public Bullet() {

    }

    public Bullet(int bulletOption) {
        switch (bulletOption) {
            case 1:
                this.Damage = 15;
                this.Speed = 12;
                this.Effect = 1;
                this.RealoadRate = 0.2;
                this.Ammunition = 20;
                this.Range = 10;
                break;
            case 2:
                this.Damage = 30;
                this.Speed = 10;
                this.Effect = 1;
                this.RealoadRate = 0.5;
                this.Ammunition = 10;
                this.Range = 12;
                break;
            case 3:
                this.Damage = 50;
                this.Speed = 15;
                this.Effect = 1;
                this.RealoadRate = 1;
                this.Ammunition = 5;
                this.Range = 15;
                break;
            case 4:
                this.Damage = 90;
                this.Speed = 0;
                this.Effect = 2;
                this.RealoadRate = 0;
                this.Ammunition = 0;
                this.Range = 1;
                break;
            default:
                System.out.println("Damn, Wrong option");
                break;
        }
    }

    private int x, y;
    private Boolean BulletAlive;

    public void SetDamage(int Value) {
        System.out.println("Hello " + Value);
    }


    public String getBullet() {
        counting += 1;
        System.out.printf("Shot %d bullets\n", counting);

        return ImagePath;
    }

    public int getRange() {
        return Range;
    }

    public int getSpeed() {
        return Speed;
    }

    public class BulletTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
            doHandle();
        }

        private void doHandle() {
            Range -= 1;
            if (Range <= 0) {

                stop();
                System.out.println("Animation stopped");
            }
        }
    }
}

public class Tank extends Application {
    private Group tank;
    private Hull hull;
    private Bullet bullet;
    private Weapon weapon;
    private Track track;
    private RotateTransition rt;
    private FadeTransition ft, ft2;
    private Scene scene;
    private Pane tankPane;
    double scale = 70 / 10.0;
    double gap = (70 - 9 * scale) / 2.0;

    //
    private double speed = 10;

    //Getter and setter methods, incase usefull to call those property from other classes.

    // Finish calling setter and getter methods

    // Constructor

    public Tank() {
    }

    public Tank(int choice, int color) {

        hull = new Hull(color, choice);
        weapon = new Weapon(color, choice);
        track = new Track(choice);
        this.bullet = new Bullet(choice);
        switch (choice) {
            case 1:
                this.speed = 15;
                break;
            case 2:
                this.speed = 20;
                break;
            case 3:
                this.speed = 13;
                break;
            case 4:
                this.speed = 18;
                break;
        }
    }

    @Override
    public void start(Stage stage) {
        //Setting title to the Stage
        stage.setTitle("Loading an image");
        Pane tankPane;
        tankPane = new Pane();
        //Load the map
        Map map = new Map();
        map.loadMap(tankPane);
        scene = new Scene(tankPane, 1400, 750);//1400x750
        //Create Player
        Tank b = new Tank(1, 2);
        b.createPlayer(350, 350, tankPane, scene);
        //Adding scene to the stage
        stage.setScene(scene);
        stage.show();


    }

    public void createPlayer(int x, int y, Pane tankPane, Scene scene) {
        this.tankPane = tankPane;
        this.scene = scene;

        //
        tank = createTank(scale);
        tankPane.getChildren().addAll(tank);
        tank.setTranslateX(x + gap);
        tank.setTranslateY(y + gap);
        tank.setCache(true);
        //Displaying the contents of the stage
        tank.setRotate(0);

        //
        rt = new RotateTransition(Duration.millis(300), tank);
        scene.setOnKeyPressed(e -> {
                    try {
                        if ((tank.getTranslateX() - gap) % 70 == 0 & (tank.getTranslateY() - gap) % 70 == 0) {
                            Move(e, scale);
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    if (tank.getRotate() == 0 | tank.getRotate() == 90 | tank.getRotate() == 180 | tank.getRotate() == 270) {
                        shootBullet(e, scale);
                    }
                }
        );
    }

    public Group createTank(double x) {
        Image weaponI = new Image(weapon.getWeapon());
        Image HullI = new Image(hull.getHull());
        Image trackI_A = new Image(track.getTrack());

        Rectangle rect = new Rectangle();
        rect.setHeight(x * 9);
        rect.setWidth(x * 9);
        rect.setFill(Color.rgb(10, 10, 10, 0));
        rect.setStroke(Paint.valueOf("green"));
        ImageView TankView = new ImageView(HullI);
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

        TankView.setX(1.25 * x);
        TankView.setY(0.5 * x);
        TankView.setFitHeight(8 * x);
        TankView.setFitWidth(6.5 * x);

        WeaponView.setX(3 * x);
        WeaponView.setFitHeight(7 * x);
        WeaponView.setFitWidth(3 * x);

        Group root = new Group(rect, TrackViewA1, TrackViewA2, TrackViewA3, TrackViewA4, TankView, WeaponView);
        //Creating a scene object
        return root;
    }

    public Bullet getBullet() {
        return bullet;
    }

    ImageView pathTrack, pathTrack2;

    public void callPathTrack(double x, double y, double direction, double scale, int step) {
        var ptr = new TranslateTransition();
        ptr.setDuration(Duration.millis(500 - 50 * (speed / 10.0 - 1)));
        ptr.setCycleCount(1);

        var ptr2 = new TranslateTransition();
        ptr2.setDuration(Duration.millis(500 - 50 * (speed / 10.0 - 1)));
        ptr2.setCycleCount(1);

        track = new Track(1);
        pathTrack = new ImageView(new Image(track.getTrackPath(2)));
        pathTrack.setFitHeight(50 * scale / 10.0);
        pathTrack.setFitWidth(50 * scale / 10.0);
        pathTrack.setRotate(tank.getRotate());
        pathTrack2 = new ImageView(new Image(track.getTrackPath(2)));
        pathTrack2.setFitHeight(50 * scale / 10.0);
        pathTrack2.setFitWidth(50 * scale / 10.0);
        pathTrack2.setRotate(tank.getRotate());
        tankPane.getChildren().addAll(pathTrack, pathTrack2);
        switch ((int) direction) {
            case 0:

                pathTrack.setX(x + 39 * scale / 10.0);
                pathTrack.setY(y + 85 * scale / 10.0);
                pathTrack2.setX(x + 2 * scale / 10.0);
                pathTrack2.setY(y + 85 * scale / 10.0);
                ptr.setNode(pathTrack);
                ptr.setToX(0);
                ptr.setToY(-step);
                ptr2.setNode(pathTrack2);
                ptr2.setToX(0);
                ptr2.setToY(-step);
                break;
            case 90:
                pathTrack.setX(x - 45 * scale / 10.0);
                pathTrack.setY(y + 39 * scale / 10.0);
                pathTrack2.setX(x - 45 * scale / 10.0);
                pathTrack2.setY(y + 2 * scale / 10.0);
                ptr.setNode(pathTrack);
                ptr.setToX(step);
                ptr.setToY(0);
                ptr2.setNode(pathTrack2);
                ptr2.setToX(step);
                ptr2.setToY(0);
                break;
            case 180:
                pathTrack.setX(x + 38 * scale / 10.0);
                pathTrack.setY(y - 40 * scale / 10.0);
                pathTrack2.setX(x + 2 * scale / 10.0);
                pathTrack2.setY(y - 40 * scale / 10.0);
                ptr.setNode(pathTrack);
                ptr.setToX(0);
                ptr.setToY(step);
                ptr2.setNode(pathTrack2);
                ptr2.setToX(0);
                ptr2.setToY(step);
                break;
            case 270:
                pathTrack.setX(x + 85 * scale / 10.0);
                pathTrack.setY(y + 37 * scale / 10.0);
                pathTrack2.setX(x + 85 * scale / 10.0);
                pathTrack2.setY(y + 2 * scale / 10.0);
                ptr.setNode(pathTrack);
                ptr.setToX(-step);
                ptr.setToY(0);
                ptr2.setNode(pathTrack2);
                ptr2.setToX(-step);
                ptr2.setToY(0);
                break;
        }

        ft = new FadeTransition(Duration.millis(800 - 50 * (speed / 10.0 - 1)), pathTrack);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft2 = new FadeTransition(Duration.millis(800 - 50 * (speed / 10.0 - 1)), pathTrack2);
        ft2.setFromValue(1.0);
        ft2.setToValue(0);
        ptr.play();
        ptr2.play();
    }
    public void moveBack(double prevX, double prevY){
        tank.setTranslateX(prevX);
        tank.setTranslateY(prevY);
    }
    public void Move(KeyEvent e, double scale) throws InterruptedException {
        double prevX = tank.getTranslateX(), prevY = tank.getTranslateY();
        int Step = 70;
        double stepDuration = (500 - 50 * (speed / 10.0 - 1)) / 35.0;
        AtomicReference<Boolean> collided = new AtomicReference<Boolean>(false);
        // Testing
        Rectangle rect = new Rectangle(60, 60);
        rect.setTranslateX(210);
        rect.setTranslateY(210);
        tankPane.getChildren().addAll(rect);
        // Testing
        Timeline timeLineMoveTank;
        KeyFrame kf = null;
        switch (e.getCode()) {
            case DOWN:
                if (tank.getRotate() != 180) {
                    rt.setByAngle(180 - tank.getRotate());
                    rt.setCycleCount(1);
                    rt.setAutoReverse(true);
                    rt.play();
                    break;
                }
                kf = new KeyFrame(
                        Duration.millis(stepDuration),
                        (evt) -> {
                            if (!tank.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                                tank.setTranslateY(tank.getTranslateY() + 2);
                            }
                        }
                );
                timeLineMoveTank = new Timeline(kf);
                timeLineMoveTank.setOnFinished(evt ->{
                    if(tank.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                        System.out.println("COLLLLIDED");
                        tank.setTranslateX(prevX);
                        tank.setTranslateY(prevY);
                    }});
                timeLineMoveTank.setCycleCount(35);
                callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate(), scale, Step);
                ft.play();
                ft2.play();
                timeLineMoveTank.play();
                break;
            case LEFT:
                if (tank.getRotate() != 270) {
                    rt.setByAngle(270 - tank.getRotate());
                    rt.setCycleCount(1);
                    rt.setAutoReverse(true);
                    rt.play();
                    break;
                }
                kf = new KeyFrame(
                        Duration.millis(stepDuration),
                        (evt) -> {
                            if (!tank.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                                tank.setTranslateX(tank.getTranslateX() - 2);
                            }
                        }
                );
                timeLineMoveTank = new Timeline(kf);
                timeLineMoveTank.setOnFinished(evt ->{
                    if(tank.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                        System.out.println("COLLLLIDED");
                        tank.setTranslateX(prevX);
                        tank.setTranslateY(prevY);
                    }});
                timeLineMoveTank.setCycleCount(35);
                callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate(), scale, Step);
                ft.play();
                ft2.play();
                timeLineMoveTank.play();
                break;
            case UP:
                if (tank.getRotate() != 0) {
                    rt.setByAngle(0 - tank.getRotate());
                    rt.setCycleCount(1);
                    rt.setAutoReverse(false);

                    rt.play();
                    break;
                }

                kf = new KeyFrame(
                        Duration.millis(stepDuration),
                        (evt) -> {
                            if (!tank.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                                tank.setTranslateY(tank.getTranslateY() - 2);
                            }
                        }
                );
                timeLineMoveTank = new Timeline(kf);
                timeLineMoveTank.setOnFinished(evt ->{
                    if(tank.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                        System.out.println("COLLLLIDED");
                        tank.setTranslateX(prevX);
                        tank.setTranslateY(prevY);
                    }});
                timeLineMoveTank.setCycleCount(35);
                callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate(), scale, Step);
                ft.play();
                ft2.play();
                timeLineMoveTank.play();

                break;
            case RIGHT:
                if (tank.getRotate() != 90) {
                    rt.setByAngle(90 - tank.getRotate());
                    rt.setCycleCount(1);
                    rt.setAutoReverse(true);

                    rt.play();
                    break;
                }
                kf = new KeyFrame(
                        Duration.millis(stepDuration),
                        (evt) -> {
                            if (!tank.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                                tank.setTranslateX(tank.getTranslateX() + 2);
                            }
                        }
                );
                timeLineMoveTank = new Timeline(kf);
                timeLineMoveTank.setOnFinished(evt ->{
                    if(tank.getBoundsInParent().intersects(rect.getBoundsInParent())) {
                    System.out.println("COLLLLIDED");
                    tank.setTranslateX(prevX);
                    tank.setTranslateY(prevY);
                }});
                timeLineMoveTank.setCycleCount(35);
                callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate(), scale, Step);
                ft.play();
                ft2.play();
                timeLineMoveTank.play();

                break;
        }
    }

    public void shootBullet(KeyEvent e, double scale) throws NullPointerException {

        if (e.getCode() == KeyCode.SPACE) {
            double x;
            double y;
            double Direction = tank.getRotate();
            int Range = 10;
            int Speed = bullet.getSpeed() / 10 * Range;
            ImageView BulletW = new ImageView(new Image(bullet.getBullet()));
            BulletW.setFitWidth(scale * 9);
            BulletW.setFitHeight(scale * 9);
            BulletW.setRotate(Direction);
            // Timeline
            double steps = scale * Range * 4 / 2.0;
            double stepDuration = 100 * Speed / steps;
            Timeline bulletAnimation;
            switch ((int) Direction) {
                case 0:
                    x = tank.getTranslateX();
                    y = tank.getTranslateY() - scale * 4.0;
                    bulletAnimation = new Timeline(
                            new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {
                                        BulletW.setTranslateY(BulletW.getTranslateY() - 2);
                                    }
                            ));
                    bulletAnimation.setOnFinished(evt -> tankPane.getChildren().remove(BulletW));
                    bulletAnimation.setOnFinished(evt -> tankPane.getChildren().remove(BulletW));
                    bulletAnimation.setCycleCount((int) steps);
                    BulletW.setX(x);
                    BulletW.setY(y);
                    bulletAnimation.play();
                    break;
                case 90:
                    x = tank.getTranslateX() + scale * 4.0;
                    y = tank.getTranslateY();
                    bulletAnimation = new Timeline(
                            new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {
                                        BulletW.setTranslateX(BulletW.getTranslateX() + 2);
                                    }
                            ));
                    bulletAnimation.setOnFinished(evt -> tankPane.getChildren().remove(BulletW));
                    bulletAnimation.setCycleCount((int) steps);
                    BulletW.setX(x);
                    BulletW.setY(y);
                    bulletAnimation.play();
                    break;
                case 180:
                    x = tank.getTranslateX();
                    y = tank.getTranslateY() + scale * 4.0;
                    bulletAnimation = new Timeline(
                            new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {
                                        BulletW.setTranslateY(BulletW.getTranslateY() + 2);
                                    }
                            ));
                    bulletAnimation.setOnFinished(evt -> tankPane.getChildren().remove(BulletW));
                    bulletAnimation.setCycleCount((int) steps);
                    BulletW.setX(x);
                    BulletW.setY(y);
                    bulletAnimation.play();
                    break;
                case 270:
                    x = tank.getTranslateX() - scale * 4.0;
                    y = tank.getTranslateY();
                    bulletAnimation = new Timeline(
                            new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {
                                        BulletW.setTranslateX(BulletW.getTranslateX() - 2);
                                    }
                            ));
                    bulletAnimation.setCycleCount((int) steps);
                    BulletW.setX(x);
                    BulletW.setY(y);
                    bulletAnimation.play();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + (int) Direction);
            }
            tankPane.getChildren().addAll(BulletW);


        }
    }
}

