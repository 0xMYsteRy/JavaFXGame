package Tank_JAVA;

import Map_JAVA.Map;
import javafx.animation.*;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.Objects;

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
    private int Damage = 0;
    private int Speed = 0;
    private int Effect;
    private double RealoadRate;
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

    public ImageView createBullet() {
        Bullet = new ImageView(new Image(ImagePath));
        Bullet.setFitWidth(5);
        Bullet.setFitHeight(5);

        return Bullet;
    }

    public ImageView getBullet(double x, double y, double Direction, double Scale) {
        System.out.println("HEllo1");
        Bullet.setX(x);
        Bullet.setY(y);
        Bullet.setFitWidth(Scale * 9);
        Bullet.setFitHeight(Scale * 9);
        Bullet.setRotate(Direction);
        return Bullet;
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
    private Group tank, tank2;
    private Hull hull;
    private Bullet bullet;
    private Weapon weapon;
    private Track track;
    private RotateTransition rt;
    private FadeTransition ft, ft2;
    private Scene scene;
    private Pane tankPane;
    double scale=70/9.0;

    //Getter and setter methods, incase usefull to call those property from other classes.

    // Finish calling setter and getter methods

    // Constructor

    public Tank() {
    }

    public Tank(int choice, int color) throws FileNotFoundException {
        hull = new Hull(color, choice);

        weapon = new Weapon(color, choice);
        track = new Track(choice);
        bullet = new Bullet(choice);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Setting title to the Stage
        stage.setTitle("Loading an image");
        Tank tankObj = new Tank(1, 2);
        Tank tankObj2= new Tank(3, 4);

        //Adding scene to the stage
        tankPane = new Pane();

        //Load the map
        Map map = new Map();
        map.loadMap(tankPane);
        tank2 = new Group(tankObj2.createTank(scale));
        tank2.setTranslateX(0);
        tank2.setTranslateY(0);
        tank2.setCache(true);
        //
        tank = tankObj.createTank(scale);
        tankPane.getChildren().addAll(tank, tank2);
        tank.setTranslateX(350);
        tank.setTranslateY(350);
        tank.setCache(true);
        //Displaying the contents of the stage
        tank.setRotate(0);
        scene = new Scene(tankPane, 1400, 750);//1400x750
        //
        rt = new RotateTransition(Duration.millis(300), tank);
        scene.setOnKeyPressed(e -> {
                    try {
                        if (tank.getTranslateX() % 70 == 0 & tank.getTranslateY() % 70 == 0) {
                            Move(e, tankPane,scale);
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    if (tank.getRotate() == 0 | tank.getRotate() == 90 | tank.getRotate() == 180 | tank.getRotate() == 270) {
                        shootBullet(e,scale);
                    }
                }
        );
        stage.setScene(scene);
        stage.show();


    }

    public Group createTank(double x) throws FileNotFoundException {


        Image weaponI = new Image(weapon.getWeapon());
        Image HullI = new Image(hull.getHull());
        Image trackI_A = new Image(track.getTrack());
        Rectangle rect= new Rectangle();
        rect.setHeight(x*9);
        rect.setWidth(x*9);
        rect.setFill(Color.rgb(10,10,10,0));
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

        Group root = new Group(rect,TrackViewA1, TrackViewA2, TrackViewA3, TrackViewA4, TankView, WeaponView);
        //Creating a scene object
        return root;
    }

    ImageView pathTrack, pathTrack2;

    public void callPathTrack(double x, double y, double direction, double scale,int step) {
        var ptr = new TranslateTransition();
        ptr.setDuration(Duration.millis(500));
        ptr.setCycleCount(1);
        ptr.setDelay(Duration.millis(1));
        var ptr2 = new TranslateTransition();
        ptr2.setDuration(Duration.millis(500));
        ptr2.setCycleCount(1);
        ptr2.setDelay(Duration.millis(1));
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

        ft = new FadeTransition(Duration.millis(800), pathTrack);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft2 = new FadeTransition(Duration.millis(800), pathTrack2);
        ft2.setFromValue(1.0);
        ft2.setToValue(0);
        ptr.play();
        ptr2.play();
    }

    public void Move(KeyEvent e, Pane tankPane,double scale) throws InterruptedException {
        var ptr = new TranslateTransition();
        int Step = 70;
        ptr.setDuration(Duration.millis(500));
        ptr.setCycleCount(1);
        ptr.setNode(tank);
        ptr.setDelay(Duration.millis(1));
            switch (e.getCode()) {
                case DOWN:
                    if (tank.getRotate() != 180) {
                        rt.setByAngle(180 - tank.getRotate());
                        rt.setCycleCount(1);
                        rt.setAutoReverse(true);
                        rt.play();
                        break;
                    }
                    ptr.setToY(tank.getTranslateY() + Step);
                    if (!tank.getBoundsInParent().intersects(tank2.getBoundsInParent())) {
                        callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate(), scale,Step);
                        ft.play();
                        ft2.play();
                        ptr.play();
                    }

                    break;
                case LEFT:
                    if (tank.getRotate() != 270) {
                        rt.setByAngle(270 - tank.getRotate());
                        rt.setCycleCount(1);
                        rt.setAutoReverse(true);
                        rt.play();
                        break;
                    }
                    ptr.setToX(tank.getTranslateX() - Step);
                    if (!tank.getBoundsInParent().intersects(tank2.getBoundsInParent())) {
                        callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate(),scale,Step);
                        ft.play();
                        ft2.play();
                        ptr.play();
                    }
                    break;
                case UP:
                    if (tank.getRotate() != 0) {
                        rt.setByAngle(0 - tank.getRotate());
                        rt.setCycleCount(1);
                        rt.setAutoReverse(false);

                        rt.play();
                        break;
                    }
                    ptr.setToY(tank.getTranslateY() - Step);
                    if (!tank.getBoundsInParent().intersects(tank2.getBoundsInParent())) {
                        callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate(), scale,Step);
                        ft.play();
                        ft2.play();
                        ptr.play();
                    }
                    break;
                case RIGHT:
                    if (tank.getRotate() != 90) {
                        rt.setByAngle(90 - tank.getRotate());
                        rt.setCycleCount(1);
                        rt.setAutoReverse(true);

                        rt.play();
                        break;
                    }

                    ptr.setToX(tank.getTranslateX() + Step);
                    if (!tank.getBoundsInParent().intersects(tank2.getBoundsInParent())) {
                        callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate(), scale,Step);
                        ft.play();
                        ft2.play();
                        ptr.play();
                    }
                    break;

            }


    }

    public void shootBullet(KeyEvent e, double scale) {
        var ptr = new TranslateTransition();
        if (e.getCode() == KeyCode.SPACE) {
            bullet = new Bullet(1);
            double x ;
            double y ;
            double Direction = tank.getRotate();
            int Range = 10;
            int Speed = bullet.getSpeed() / 10 * Range;
//                System.out.println(2);

            ImageView bulletImg ;
            switch ((int) Direction) {
                case 0:
                    x=tank.getTranslateX();
                    y = tank.getTranslateY()- scale*4.0;
                    ptr.setToY(-scale * Range * 4);
                    bulletImg = bullet.getBullet(x, y, Direction, scale);
                    break;
                case 90:
                    x=tank.getTranslateX()+scale*4.0;
                    y = tank.getTranslateY();
                    ptr.setToX(scale * Range * 4);
                    bulletImg = bullet.getBullet(x, y, Direction, scale);
                    break;
                case 180:
                    x=tank.getTranslateX();
                    y = tank.getTranslateY()+scale*4.0;
                    ptr.setToY(scale * Range * 4);
                    bulletImg = bullet.getBullet(x, y, Direction, scale);
                    break;
                case 270:
                    x=tank.getTranslateX()-scale*4.0;
                    y = tank.getTranslateY();
                    ptr.setToX(-scale * Range * 4);
                    bulletImg = bullet.getBullet(x, y, Direction, scale);

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + (int) Direction);
            }

            ptr.setDuration(Duration.millis(100 * Speed));

            ptr.setCycleCount(1);

            tankPane.getChildren().addAll(bulletImg);
            ptr.setNode(bulletImg);
            System.out.println("Before Shooting");
            ptr.setDelay(Duration.millis(1));
            ptr.play();
            ptr.setOnFinished(event -> tankPane.getChildren().remove(bulletImg));
        }
    }
}

