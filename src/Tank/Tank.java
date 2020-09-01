package Tank;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

class Object {
    private int Option;

    public String getImage(String Option) throws FileNotFoundException {
        return "file:" + "src/Brick/brick" + Option + ".png";
    }
}

public class Tank extends Application {
    private Group tank = new Group(createTank(3, 1, 7));
    private Object objectImage = new Object();


    public Tank() throws FileNotFoundException {
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Setting title to the Stage
        stage.setTitle("Java Game");


        // Create a map
        // Image
        Image Image1 = new Image(objectImage.getImage("2"));
        Image Image2 = new Image(objectImage.getImage("2"));
        Image Image3 = new Image(objectImage.getImage("2"));
        Image Image4 = new Image(objectImage.getImage("2"));
        Image Image5 = new Image(objectImage.getImage("2"));
        Image Image6 = new Image(objectImage.getImage("2"));
        Image Image7 = new Image(objectImage.getImage("2"));
        Image Image8 = new Image(objectImage.getImage("2"));


        //ImageView
        ImageView wall1 = new ImageView(Image1);
        ImageView wall2 = new ImageView(Image2);
        ImageView wall3 = new ImageView(Image3);
        ImageView wall4 = new ImageView(Image4);
        ImageView wall5 = new ImageView(Image5);
        ImageView wall6 = new ImageView(Image6);
        ImageView wall7 = new ImageView(Image7);
        ImageView wall8 = new ImageView(Image8);

        //Adding scene to the stage
        Pane tankPane = new Pane();
        // Add object to display to the scence
        // tankPane.getChildren().add(object);

        wall1.setFitHeight(4.0*6);
        wall1.setFitWidth(4.0*6);
        wall1.setTranslateX(0);
        wall1.setTranslateY(600);

        wall2.setFitHeight(4.0*6);
        wall2.setFitWidth(4.0*6);
        wall2.setTranslateX(20);
        wall2.setTranslateY(600);

        wall3.setFitHeight(4.0*6);
        wall3.setFitWidth(4.0*6);
        wall3.setTranslateX(40);
        wall3.setTranslateY(600);

        wall4.setFitHeight(4.0*6);
        wall4.setFitWidth(4.0*6);
        wall4.setTranslateX(60);
        wall4.setTranslateY(600);

        wall5.setFitHeight(4.0*6);
        wall5.setFitWidth(4.0*6);
        wall5.setTranslateX(80);
        wall5.setTranslateY(600);

        wall6.setFitHeight(4.0*6);
        wall6.setFitWidth(4.0*6);
        wall6.setTranslateX(100);
        wall6.setTranslateY(600);

        wall7.setFitHeight(4.0*6);
        wall7.setFitWidth(4.0*6);
        wall7.setTranslateX(120);
        wall7.setTranslateY(600);

        wall8.setFitHeight(4.0*6);
        wall8.setFitWidth(4.0*6);
        wall8.setTranslateX(140);
        wall8.setTranslateY(600);

        tank.setTranslateX(500);
        tank.setTranslateY(500);
        // Add tank to display to the scence
        tankPane.getChildren().addAll(tank,wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8);

        //Displaying the contents of the stage
        tank.setRotate(0);
        Scene scene = new Scene(tankPane, 1440, 1080);
        Move(scene);

        stage.setScene(scene);
        stage.show();
    }

    public Group createTank(int choice, int color, int x) throws FileNotFoundException {
        Hull hull = new Hull(color, choice);
        Bullet bullet = new Bullet(choice);
        Weapon weapon = new Weapon(color, choice);
        Track track = new Track(choice);

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

        //Creating a scene object
        return new Group(TrackViewA1, TrackViewA2, TrackViewA3, TrackViewA4, TankView, WeaponView);
    }

    public void Move(Scene scene) {
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
                    tank.setRotate(180);
                    tank.setTranslateY(tank.getTranslateY() + 10);
                    break;
                case LEFT:
                    tank.setRotate(270);
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
                default:
                    break;
            }
        });
    }
}