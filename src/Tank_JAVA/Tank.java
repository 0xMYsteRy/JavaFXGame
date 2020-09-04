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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;

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
        Option = (Option - 1) % 3 + 1;

    }

    public String getTrackPath(int TrackPathOption) {

        return "file:" + "src/PNG/Effects/Tire_Track_0" + TrackPathOption + ".png";
    }

    public String getTrack(String Animation) {
        return "file:" + "src/PNG/Tracks/Track_" + Option + "_" + Animation + ".png";
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
                Damage = 15;
                Speed = 12;
                Effect = 1;
                RealoadRate = 0.2;
                Ammunition = 20;
                Range = 10;
                break;
            case 2:
                Damage = 30;
                Speed = 10;
                Effect = 1;
                RealoadRate = 0.5;
                Ammunition = 10;
                Range = 12;
                break;
            case 3:
                Damage = 50;
                Speed = 15;
                Effect = 1;
                RealoadRate = 1;
                Ammunition = 5;
                Range = 15;
                break;
            case 4:
                Damage = 90;
                Speed = 0;
                Effect = 2;
                RealoadRate = 0;
                Ammunition = 0;
                Range = 1;
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

    public ImageView getBullet(double x, double y, double Direction, int Scale) {
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

    private Group tank = new Group();
    private Hull hull;
    private Bullet bullet;
    private Weapon weapon;
    private Track track;
    private RotateTransition rt;
    private Scene scene;
    private Pane tankPane;

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


        //Adding scene to the stage
        tankPane = new Pane();

        //Load the map
        Map map = new Map();
        map.loadMap(tankPane);
        tank = tankObj.createTank(10);
        tankPane.getChildren().addAll(tank);
        tank.setTranslateX(500);
        tank.setTranslateY(500);
        //Displaying the contents of the stage
        tank.setRotate(0);
        scene = new Scene(tankPane, 1400, 750);//1400x750
        //
        rt = new RotateTransition(Duration.millis(300), tank);
        scene.setOnKeyPressed(e -> {
                    Move(e);
                    if (tank.getRotate() == 0 | tank.getRotate() == 90 | tank.getRotate() == 180 | tank.getRotate() == 270) {
                        shootBullet(e);
                    }
                }
        );
        stage.setScene(scene);
        stage.show();


    }

    public Group createTank(int x) throws FileNotFoundException {


        Image weaponI = new Image(weapon.getWeapon());
        Image HullI = new Image(hull.getHull());
        Image trackI_A = new Image(track.getTrack("A"));
        Image trackI_B = new Image(track.getTrack("B"));

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
        TrackViewA2.setX(2.1 * x);
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

        Group root = new Group(TrackViewA1, TrackViewA2, TrackViewA3, TrackViewA4, TankView, WeaponView);
        //Creating a scene object
        return root;
    }

    public void Move(KeyEvent e) {
        var ptr = new TranslateTransition();
        int Step = 100;
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

                ptr.play();
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
                ptr.play();
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
                ptr.play();
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
                ptr.play();
                break;

        }


    }

    public void shootBullet(KeyEvent e) {
        var ptr = new TranslateTransition();
        if (e.getCode() == KeyCode.SPACE) {
            bullet = new Bullet(1);
            double x = tank.getTranslateX();
            double y = tank.getTranslateY();
            double Direction = tank.getRotate();
            int Scale = 10;
            int Range = 10;
            int Speed = bullet.getSpeed() / 10 * Range;
//                System.out.println(2);

            switch ((int) Direction) {
                case 0:
                    ptr.setToY(-Scale * Range * 4);
                    break;
                case 90:
                    ptr.setToX(Scale * Range * 4);
                    break;
                case 180:
                    ptr.setToY(Scale * Range * 4);
                    break;
                case 270:
                    ptr.setToX(-Scale * Range * 4);

                    break;
            }

            ptr.setDuration(Duration.millis(100 * Speed));

            ptr.setCycleCount(1);
            ImageView bulletImg = bullet.getBullet(x, y, Direction, Scale);

            tankPane.getChildren().addAll(bulletImg);
            ptr.setNode(bulletImg);
            System.out.println("Before Shooting");
            ptr.setDelay(Duration.millis(1));
            ptr.play();
            System.out.println(ptr.getToX() + " " + ptr.getByX());
            ptr.setOnFinished(event -> tankPane.getChildren().remove(bulletImg));
        }
    }
}

