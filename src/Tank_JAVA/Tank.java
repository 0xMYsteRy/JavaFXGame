package Tank_JAVA;

import Map_JAVA.Map2;
import Map_JAVA.Map3;
import Map_JAVA.MapJungle;
import Map_JAVA.Mapboss;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;
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
    private String ImagePath = "file:src/PNG/Effects/Exhaust_Fire.png";
    private String ImagePath2 = "file:src/PNG/Effects/Plasma.png";

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
                this.Damage = 11;
                this.Speed = 10;
                this.Effect = 1;
                this.RealoadRate = 0.5;
                this.Ammunition = 10;
                this.Range = 12;
                break;
            case 3:
                this.Damage = 24;
                this.Speed = 15;
                this.Effect = 1;
                this.RealoadRate = 1;
                this.Ammunition = 5;
                this.Range = 15;
                break;
            case 4:
                this.Damage = 22;
                this.Speed = 16;
                this.Effect = 2;
                this.RealoadRate = 0;
                this.Ammunition = 0;
                this.Range = 19;
                break;
            case 5:
                this.Damage = 15;
                this.Speed = 12;
                this.Effect = 1;
                this.RealoadRate = 0.2;
                this.Ammunition = 10;
                this.Range = 10;
                break;
            case 6:
                this.Damage = 20;
                this.Speed = 10;
                this.Effect = 1;
                this.RealoadRate = 0.5;
                this.Ammunition = 14;
                this.Range = 12;
                break;
            case 7:
                this.Damage = 18;
                this.Speed = 15;
                this.Effect = 1;
                this.RealoadRate = 1;
                this.Ammunition = 7;
                this.Range = 15;
                break;
            case 8:
                this.Damage = 20;
                this.Speed = 19;
                this.Effect = 2;
                this.RealoadRate = 0;
                this.Ammunition = 0;
                this.Range = 20;
                break;
            default:
                System.out.println("Damn, Wrong Bullet option " + bulletOption);
                break;
        }
    }

    private int x, y;
    private Boolean BulletAlive;

    public void SetDamage(int Value) {

    }

    public int getDamage() {
        return Damage;
    }

    public void SetReload(int Value) {

    }

    public double getReload() {
        return RealoadRate;
    }

    public String getBullet(int choice) {
        counting += 1;
//        System.out.printf("Shot %d bullets\n", counting);
        switch (choice % 3) {
            case 1:
                return ImagePath;
            case 2:
                return ImagePath2;
            default:
                return ImagePath;
        }
    }

    public void setAmmunition(int Amount) {
        Ammunition += Amount;
    }

    public int getAmmunition() {
        return Ammunition;
    }

    public int getRange() {
        return Range;
    }

    public int getSpeed() {
        return Speed;
    }

}

class Flash {
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

class Explosion {
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

    public void ExplosionAnimation(double x, double y, Pane tankPane) {
        a1.setFitWidth(70);
        a1.setFitHeight(70);
        a2.setFitWidth(70);
        a2.setFitHeight(70);
        a3.setFitWidth(70);
        a3.setFitHeight(70);
        a4.setFitWidth(70);
        a4.setFitHeight(70);
        a5.setFitWidth(70);
        a5.setFitHeight(70);
        a6.setFitWidth(70);
        a6.setFitHeight(70);
        a7.setFitWidth(70);
        a7.setFitHeight(70);
        a8.setFitWidth(70);
        a8.setFitHeight(70);
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
    // Stat of resolution
    double scale = 70 / 10.0;
    double gap = (70 - 9 * scale) / 2.0;
    double Step = 35;
    // Stat of tank
    private int bulletMode = 1;
    private double speed = 0;
    private double Health = 0;
    //Bullet
    private int BulletDamage = 0;
    private double BulletSpeed = 0;
    private double BulletReloadRate = 0;
    private double BulletAmmunition = 0;
    private double Range = 0;

    //Getter and setter methods, incase usefull to call those property from other classes.
    // Finish calling setter and getter methods
    private ArrayList<Rectangle> RectList;
    private ArrayList<ImageView> ObjList;
    private ArrayList<Bot> BotList;

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
                this.Health = 100;
                break;
            case 2:
                this.speed = 20;
                this.Health = 100;
                break;
            case 3:
                this.speed = 13;
                this.Health = 100;
                break;
            case 4:
                this.speed = 18;
                this.Health = 100;
                break;
        }
        this.BulletAmmunition = bullet.getAmmunition();
        this.BulletDamage = bullet.getDamage();
        this.BulletReloadRate = bullet.getReload();
        this.BulletSpeed = bullet.getSpeed();
        this.Range = bullet.getRange();
    }

    @Override
    public void start(Stage stage) {
        //Setting title to the Stage
        stage.setTitle("Loading an image");
        Pane tankPane;
        tankPane = new Pane();
        //Load the map
        MapJungle map = new MapJungle();

        map.loadGround(tankPane);
        scene = new Scene(tankPane, 1400, 770);//1400x750
        //Create Player
        Tank b = new Tank(2, 1);

        b.createPlayer(350, 350, tankPane, scene, map.getRectList(), map.getobjectList(), map.getObjBotList());
        //Create Bot
//        map.loadBot(tankPane, b, scene);
        //Adding scene to the stage
        map.loadObject(tankPane);
        stage.setScene(scene);
        stage.show();


    }

    Random random = new Random();

    public void setHealth(int damage) {
        Health -= damage;
        Text dam = new Text("-"+ damage);
        dam.setFill(Color.RED);
        dam.setFont(Font.font("verdana",FontWeight.EXTRA_BOLD,15));
        dam.setStroke(Color.WHITESMOKE);
        dam.setStrokeWidth(0.5);
        double iniX = tank.getTranslateX() + random.nextInt(10+10)  +17, iniY = tank.getTranslateY() + random.nextInt(10+10) + 5;
        dam.setX(iniX);
        dam.setY(iniY);
        tankPane.getChildren().add(dam);
        Timeline minusHealth = new Timeline(new KeyFrame(Duration.millis(50),
                actionEvent -> {
                    if (iniX > tank.getTranslateX()+25) {
                        dam.setX(dam.getX() + 1);
                        dam.setY(dam.getY() - 5);
                    }else {
                        dam.setX(dam.getX() - 1);
                        dam.setY(dam.getY() - 5);
                    }
                    dam.setOpacity(dam.getOpacity() - 0.1);
                }));
        minusHealth.setCycleCount(20);
        minusHealth.setOnFinished(evt->tankPane.getChildren().remove(dam));
        minusHealth.play();
        checkHealth();
    }
    public void checkHealth(){
        if (Health<=0){
            System.out.println(Health);
        }
    }

    public void createPlayer(int x, int y, Pane tankPane, Scene scene, ArrayList<Rectangle> rectList, ArrayList<ImageView> objList, ArrayList<Bot> BotList) {
        this.ObjList = objList;
        this.RectList = rectList;
        this.tankPane = tankPane;
        this.scene = scene;
        this.BotList = BotList;
        //
        Random rand = new Random();

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
        scene.setOnKeyPressed(keyEvent -> {
            try {
                if ((tank.getTranslateX() - gap) % Step == 0 & (tank.getTranslateY() - gap) % Step == 0) {
                    Move(keyEvent);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        scene.setOnKeyReleased(e -> {
                    if (tank.getRotate() == 0 | tank.getRotate() == 90 | tank.getRotate() == 180 | tank.getRotate() == 270) {
                        shootBullet(e);

                    }
                }
        );
    }

    public Group createTank(double x) {
        Image weaponI = new Image(weapon.getWeapon());
        Image HullI = new Image(hull.getHull());
        Image trackI_A = new Image(track.getTrack());

//        Rectangle rect = new Rectangle();
//        rect.setHeight(x * 9);
//        rect.setWidth(x * 9);
//        rect.setFill(Color.rgb(10, 10, 10, 0));
//
//        rect.setStroke(Paint.valueOf("green"));
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

        Group root = new Group(TrackViewA1, TrackViewA2, TrackViewA3, TrackViewA4, TankView, WeaponView);

        //Creating a scene object
        return root;
    }

    public Group getTank() {
        return tank;
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
        pathTrack.setRotate(tank.getRotate());
        ImageView pathTrack2 = new ImageView(new Image(track.getTrackPath(2)));
        pathTrack2.setFitHeight(50 * scale / 10.0);
        pathTrack2.setFitWidth(50 * scale / 10.0);
        pathTrack2.setRotate(tank.getRotate());
        tankPane.getChildren().addAll(pathTrack, pathTrack2);
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

    private int check = 0;

    public void Move(KeyEvent e) throws InterruptedException {
        check = 0;
        double prevX = tank.getTranslateX(), prevY = tank.getTranslateY();
        double stepDuration = (500 - 50 * (speed / 10.0 - 1)) / (70 / Step * 35);
        // Testing
        Timeline timeLineMoveTank;
        KeyFrame kf;
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
                            if (check == 0) {
                                for (Rectangle rectV : RectList) {
                                    if (tank.getBoundsInParent().intersects(rectV.getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                for (Bot bot : BotList) {
                                    if (tank.getBoundsInParent().intersects(bot.getBot().getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                for (ImageView imgW : ObjList) {
                                    if (tank.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                if (tank.getTranslateX() <= 0 | tank.getTranslateY() >= 770 | tank.getTranslateY() <= 0 | tank.getTranslateX() >= 1365) {
                                    check = 1;
                                }
                            }
                            if (check == 0) {
                                tank.setTranslateY(tank.getTranslateY() + Step * 2 / 70.0);
                            }
                        }
                );
                timeLineMoveTank = new Timeline(kf);
                timeLineMoveTank.setOnFinished(evt -> {
                    if (check == 1) {
                        System.out.println(tank.getTranslateX());
                        tank.setTranslateX(prevX);
                        tank.setTranslateY(prevY);
                    }
                });
                timeLineMoveTank.setCycleCount((int) Step);
                callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate());
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

                            if (check == 0) {
                                for (Rectangle rectW : RectList) {
                                    if (tank.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                for (Bot bot : BotList) {
                                    if (tank.getBoundsInParent().intersects(bot.getBot().getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                for (ImageView imgW : ObjList) {
                                    if (tank.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                if (tank.getTranslateX() <= 0 | tank.getTranslateY() >= 770 | tank.getTranslateY() <= 0 | tank.getTranslateX() >= 1365) {
                                    check = 1;
                                }
                            }
                            if (check == 0) {
                                tank.setTranslateX(tank.getTranslateX() - Step * 2 / 70.0);
                            }
                        }
                );
                timeLineMoveTank = new Timeline(kf);
                timeLineMoveTank.setOnFinished(evt -> {
                    if (check == 1) {
                        tank.setTranslateX(prevX);
                        tank.setTranslateY(prevY);
                    }
                });
                timeLineMoveTank.setCycleCount((int) Step);
                callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate());
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
                            if (check == 0) {
                                for (Rectangle rectW : RectList) {
                                    if (tank.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                for (ImageView imgW : ObjList) {
                                    if (tank.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                for (Bot bot : BotList) {
                                    if (tank.getBoundsInParent().intersects(bot.getBot().getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                if (tank.getTranslateX() <= 0 | tank.getTranslateY() >= 770 | tank.getTranslateY() <= 0 | tank.getTranslateX() >= 1365) {
                                    check = 1;
                                }
                            }
                            if (check == 0) {
                                tank.setTranslateY(tank.getTranslateY() - Step * 2 / 70.0);
                            }
                        }
                );
                timeLineMoveTank = new Timeline(kf);
                timeLineMoveTank.setOnFinished(evt -> {
                    if (check == 1) {
                        tank.setTranslateX(prevX);
                        tank.setTranslateY(prevY);
                    }
                });
                timeLineMoveTank.setCycleCount((int) Step);
                callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate());
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
                            if (check == 0) {
                                for (Rectangle rectW : RectList) {
                                    if (tank.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                for (ImageView imgW : ObjList) {
                                    if (tank.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                for (Bot bot : BotList) {
                                    if (tank.getBoundsInParent().intersects(bot.getBot().getBoundsInParent())) {
                                        check = 1;
                                        break;
                                    }
                                }
                                if (tank.getTranslateX() <= 0 | tank.getTranslateY() >= 735 | tank.getTranslateY() <= 0 | tank.getTranslateX() >= 1365) {
                                    check = 1;
                                }
                            }
                            if (check == 0) {
                                tank.setTranslateX(tank.getTranslateX() + Step * 2 / 70.0);
                            }
                        }
                );
                timeLineMoveTank = new Timeline(kf);
                timeLineMoveTank.setOnFinished(evt -> {
                    if (check == 1) {
                        tank.setTranslateX(prevX);
                        tank.setTranslateY(prevY);
                    }
                });
                timeLineMoveTank.setCycleCount((int) Step);
                callPathTrack(tank.getTranslateX(), tank.getTranslateY(), tank.getRotate());
                ft.play();
                ft2.play();
                timeLineMoveTank.play();
                break;
        }
    }

    private int checkBullet;

    public void shootBullet(KeyEvent e) throws NullPointerException {

        if (e.getCode() == KeyCode.SPACE) {
            AtomicReference<Boolean> shotBullet = new AtomicReference<>(false);
            Explosion explosion = new Explosion();
            Flash flash = new Flash();
            double x;
            double y;
            double Direction = tank.getRotate();
            double Speed = BulletSpeed / 10.0 * Range;
            ImageView BulletW = new ImageView(new Image(bullet.getBullet(bulletMode)));
            BulletW.setFitWidth(scale * 9);
            BulletW.setFitHeight(scale * 9);
            BulletW.setRotate(Direction);
            tankPane.getChildren().addAll(BulletW);
            // Timeline
            double steps = scale * Range * 4 / 2.0;
            double stepDuration = 100 * Speed / steps;
            Timeline bulletAnimation;
            switch ((int) Direction) {
                case 0:
                    x = tank.getTranslateX();
                    y = tank.getTranslateY() - scale * 4.0;
                    flash.FlashAnimation(x, y - scale * 4.0, BulletW.getRotate(), BulletW.getFitWidth(), bulletMode, tankPane);
                    bulletAnimation = new Timeline(
                            new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {
                                        checkBullet = 0;
                                        if ((BulletW.getTranslateY() % 70) % 36 == 0 & BulletW.getTranslateY() % 70 != 0 & !shotBullet.get()) {
                                            for (Rectangle rectW : RectList) {
                                                if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    break;
                                                }
                                            }
                                            for (ImageView imgW : ObjList) {
                                                if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), tankPane);
                                                    tankPane.getChildren().remove(imgW);
                                                    ObjList.remove(imgW);
                                                    break;
                                                }
                                            }
                                            for (Bot bot : BotList) {
                                                if (BulletW.getBoundsInParent().intersects(bot.getBot().getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    explosion.ExplosionAnimation(bot.getBot().getTranslateX(), bot.getBot().getTranslateY(), tankPane);
                                                    bot.setHealth(BulletDamage);
                                                    if (!bot.checkHealth()){
                                                        BotList.remove(bot);
                                                    }
                                                    break;
                                                }
                                            }

                                        }
                                        if (checkBullet == 0) {
                                            BulletW.setTranslateY(BulletW.getTranslateY() - 2);
                                        } else {
                                            tankPane.getChildren().remove(BulletW);
                                            shotBullet.set(true);
                                        }
                                    }
                            ));
                    bulletAnimation.setOnFinished(evt -> {
//                        System.out.printf("Exploded at %f x - %f y\n", BulletW.getTranslateX(), BulletW.getTranslateY());
                        tankPane.getChildren().remove(BulletW);
                    });
                    bulletAnimation.setCycleCount((int) steps);
                    BulletW.setX(x);
                    BulletW.setY(y);
                    bulletAnimation.play();
                    break;
                case 90:
                    x = tank.getTranslateX() + scale * 4.0;
                    y = tank.getTranslateY();
                    flash.FlashAnimation(x + scale * 4.0, y, BulletW.getRotate(), BulletW.getFitWidth(), bulletMode, tankPane);
                    bulletAnimation = new Timeline(
                            new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {
                                        int checkBullet = 0;
                                        if ((BulletW.getTranslateX() % 70) % 36 == 0 & BulletW.getTranslateX() % 70 != 0 & !shotBullet.get()) {
                                            for (Rectangle rectW : RectList) {
                                                if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    break;
                                                }
                                            }
                                            for (Bot bot : BotList) {
                                                if (BulletW.getBoundsInParent().intersects(bot.getBot().getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    explosion.ExplosionAnimation(bot.getBot().getTranslateX(), bot.getBot().getTranslateY(), tankPane);
                                                    bot.setHealth(BulletDamage);
                                                    if (!bot.checkHealth()){
                                                        BotList.remove(bot);
                                                    }
                                                    break;
                                                }
                                            }
                                            for (ImageView imgW : ObjList) {
                                                if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    tankPane.getChildren().remove(imgW);
                                                    explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), tankPane);

                                                    ObjList.remove(imgW);
                                                    break;
                                                }
                                            }
                                        }

                                        if (checkBullet == 0) {
                                            BulletW.setTranslateX(BulletW.getTranslateX() + 2);
                                        } else {
                                            tankPane.getChildren().remove(BulletW);
                                            shotBullet.set(true);
                                        }
                                    }
                            ));
                    bulletAnimation.setOnFinished(evt -> {
//                        System.out.printf("Exploded at %f x - %f y\n", BulletW.getTranslateX(), BulletW.getTranslateY());
                        tankPane.getChildren().remove(BulletW);
                    });
                    bulletAnimation.setCycleCount((int) steps);
                    BulletW.setX(x);
                    BulletW.setY(y);
                    bulletAnimation.play();
                    break;
                case 180:
                    x = tank.getTranslateX();
                    y = tank.getTranslateY() + scale * 4.0;
                    flash.FlashAnimation(x, y + scale * 4.0, BulletW.getRotate(), BulletW.getFitWidth(), bulletMode, tankPane);
                    bulletAnimation = new Timeline(
                            new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {
                                        int checkBullet = 0;
                                        if ((BulletW.getTranslateY() % 70) % 36 == 0 & BulletW.getTranslateY() % 70 != 0 & !shotBullet.get()) {
                                            for (Rectangle rectW : RectList) {
                                                if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    break;
                                                }
                                            }
                                            for (Bot bot : BotList) {
                                                if (BulletW.getBoundsInParent().intersects(bot.getBot().getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    explosion.ExplosionAnimation(bot.getBot().getTranslateX(), bot.getBot().getTranslateY(), tankPane);
                                                    bot.setHealth(BulletDamage);
                                                    if (!bot.checkHealth()){
                                                        BotList.remove(bot);
                                                    }
                                                    break;
                                                }
                                            }
                                            for (ImageView imgW : ObjList) {
                                                if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    tankPane.getChildren().remove(imgW);
                                                    explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), tankPane);

                                                    ObjList.remove(imgW);
                                                    break;
                                                }
                                            }


                                        }
                                        if (checkBullet == 0) {
                                            BulletW.setTranslateY(BulletW.getTranslateY() + 2);
                                        } else {
                                            tankPane.getChildren().remove(BulletW);
                                            shotBullet.set(true);
                                        }
                                    }
                            ));
                    bulletAnimation.setOnFinished(evt -> {
//                        System.out.printf("Exploded at %f x - %f y\n", BulletW.getTranslateX(), BulletW.getTranslateY());
                        tankPane.getChildren().remove(BulletW);
                    });
                    bulletAnimation.setCycleCount((int) steps);
                    BulletW.setX(x);
                    BulletW.setY(y);
                    bulletAnimation.play();
                    break;
                case 270:
                    x = tank.getTranslateX() - scale * 4.0;
                    y = tank.getTranslateY();
                    flash.FlashAnimation(x - scale * 4.0, y, BulletW.getRotate(), BulletW.getFitWidth(), bulletMode, tankPane);
                    bulletAnimation = new Timeline(
                            new KeyFrame(
                                    Duration.millis(stepDuration),
                                    (evt) -> {
                                        int checkBullet = 0;
                                        if ((BulletW.getTranslateX() % 70) % 36 == 0 & BulletW.getTranslateX() % 70 != 0 & !shotBullet.get()) {
                                            for (Rectangle rectW : RectList) {
                                                if (BulletW.getBoundsInParent().intersects(rectW.getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    break;
                                                }
                                            }
                                            for (Bot bot : BotList) {
                                                if (BulletW.getBoundsInParent().intersects(bot.getBot().getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    explosion.ExplosionAnimation(bot.getBot().getTranslateX(), bot.getBot().getTranslateY(), tankPane);
                                                    bot.setHealth(BulletDamage);
                                                    if (!bot.checkHealth()){
                                                        BotList.remove(bot);
                                                    }
                                                    break;
                                                }
                                            }
                                            for (ImageView imgW : ObjList) {
                                                if (BulletW.getBoundsInParent().intersects(imgW.getBoundsInParent())) {
                                                    checkBullet = 1;
                                                    tankPane.getChildren().remove(imgW);
                                                    explosion.ExplosionAnimation(imgW.getTranslateX(), imgW.getTranslateY(), tankPane);
                                                    ObjList.remove(imgW);
                                                    break;
                                                }
                                            }

                                        }
                                        if (checkBullet == 0) {
                                            BulletW.setTranslateX(BulletW.getTranslateX() - 2);
                                        } else {
                                            tankPane.getChildren().remove(BulletW);
                                            shotBullet.set(true);
                                        }
                                    }
                            ));
                    bulletAnimation.setOnFinished(evt -> {
//                        System.out.printf("Exploded at %f x - %f y\n", BulletW.getTranslateX(), BulletW.getTranslateY());
                        tankPane.getChildren().remove(BulletW);
                    });

                    bulletAnimation.setCycleCount((int) steps);
                    BulletW.setX(x);
                    BulletW.setY(y);
                    bulletAnimation.play();

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + (int) Direction);

            }

        }
    }
}
