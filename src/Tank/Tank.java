package Tank;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

/*MAC: --module-path "/Users/s3757937/Downloads/javafx-sdk-11.0.2/lib" --add-modules javafx.controls,javafx.fxml*/
class Hull {
    private int color;
    private int type;

    Hull(int Color, int Type) {
        this.color = Color;
        this.type = Type;
    }

    public String getHull() {
        String colorPath = "";
        switch (color) {
            case 1:
                colorPath = "A";
            case 2:
                colorPath = "B";
            case 3:
                colorPath = "C";
            case 4:
                colorPath = "D";
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
        String colorPath = "";
        switch (color) {
            case 1:
                colorPath = "A";
            case 2:
                colorPath = "B";
            case 3:
                colorPath = "C";
            case 4:
                colorPath = "D";
        }
        return "file:" + "src/PNG/Weapon_Color_" + colorPath + "/Gun_0" + Option + ".png";
    }
}

class Track {
    private final float duration = 1;
    private int Option;

    Track(int Option) {
        Option = (Option - 1) % 3 + 1;
        this.Option = Option;
    }

    public String getTrackPath(int TrackPathOption) {
        return "file:" + "src/PNG/Effects/Tire_Track_0" + TrackPathOption + ".png";
    }

    public String getTrack(String Animation) {
        return "file:" + "src/PNG/Tracks/Track_" + Option + "_" + Animation + ".png";
    }
}

class Bullet {
    private int Damage;
    private int Speed;
    private int Effect;
    private double RealoadRate;
    private int Ammunition;
    private int Range;
    private String ImagePath;

    Bullet(int bulletOption) {
        switch (bulletOption) {
            case 1:
                Damage = 15;
                Speed = 12;
                Effect = 1;
                RealoadRate = 0.2;
                Ammunition = 20;
                Range = 10;
            case 2:
                Damage = 30;
                Speed = 10;
                Effect = 1;
                RealoadRate = 0.5;
                Ammunition = 10;
                Range = 12;
            case 3:
                Damage = 50;
                Speed = 15;
                Effect = 1;
                RealoadRate = 1;
                Ammunition = 5;
                Range = 15;
            case 4:
                Damage = 90;
                Speed = 0;
                Effect = 2;
                RealoadRate = 0;
                Ammunition = 0;
                Range = 1;
        }
    }

    public void SetDamage(int Value) {

    }

    public String getBullet() {
        return "a";
    }
}

public class Tank extends Application {

    private Group tank = new Group();
    private Hull hull;
    private Bullet bullet;
    private Weapon weapon;
    private Track track;
    public Tank() throws FileNotFoundException {

    }
    public Tank(int choice, int color) throws FileNotFoundException {
        hull = new Hull(color, choice);
        bullet = new Bullet(choice);
        weapon = new Weapon(color, choice);
        track = new Track(choice);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Setting title to the Stage
        stage.setTitle("Loading an image");
        Tank tankObj = new Tank(1,1);
        //Adding scene to the stage
        Pane tankkk = new Pane();
        tank=tankObj.createTank( 10);
        tankkk.getChildren().addAll(tank);
        tank.setTranslateX(500);
        tank.setTranslateY(500);
        //Displaying the contents of the stage
        tank.setRotate(0);
        Scene scene = new Scene(tankkk, 1000,
                800);
        Move(scene);

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
        ImageView TrackviewB = new ImageView(trackI_B);
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

        TrackviewB.setX(0);
        TrackviewB.setFitHeight(9 * x);
        TrackviewB.setFitWidth(7 * x);

        TankView.setX(1.5 * x);
        TankView.setY(0.5 * x);
        TankView.setFitHeight(8 * x);
        TankView.setFitWidth(6 * x);

        WeaponView.setX(3 * x);
        WeaponView.setFitHeight(7 * x);
        WeaponView.setFitWidth(3 * x);

        Group root = new Group(TrackViewA1, TrackViewA2, TrackViewA3, TrackViewA4, TankView, WeaponView);
        //Creating a scene object
        return root;
    }

    public void Move(Scene scene) {
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
                    tank.setRotate(180);
                for(int i =0; i <5; i ++)        {
                    tank.setTranslateY(tank.getTranslateY() + 2);
                }
                    break;
                case LEFT:if (tank.getRotate()!=270) {

                }
                    tank.setTranslateX(tank.getTranslateX() - 10);
                    break;
                case UP:
                    tank.setRotate(360);
                    tank.setTranslateY(tank.getTranslateY() - 10);
                    break;
                case RIGHT:
                    tank.setRotate(90);
                    tank.setTranslateX(tank.getTranslateX() + 10);
                    break;
            }
        });
    }
}