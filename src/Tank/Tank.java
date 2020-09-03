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

    public String getImage(String Option) {
        return "file:" + "src/Brick/brick" + Option + ".png";
    }
}

public class Tank extends Application {
    private Group tank = new Group(createTank(3, 1, 7));
    private Object objectImage = new Object();
    Pane tankPane;
    public Tank() throws FileNotFoundException {
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Setting title to the Stage
        stage.setTitle("Java Game");
        // Image
        // Image Image1 = new Image(objectImage.getImage("2"));
        //ImageView
        // ImageView wall1 = new ImageView(Image1);


        //Adding scene to the stage
        tankPane = new Pane();

        loadImage();
        tank.setTranslateX(600);
        tank.setTranslateY(600);
        // Add tank to display to the scence
        tankPane.getChildren().addAll(tank);

        //Displaying the contents of the stage
        tank.setRotate(0);
        Scene scene = new Scene(tankPane, 1400, 1050);
        Move(scene);

        stage.setScene(scene);
        stage.show();
    }
    public void loadImage(){
        // Load image
        Image image1 = new Image("file:src/Ultilities/PNG/Ground_Tile_01_C.png");
        Image image2= new Image("file:src/Ultilities/PNG/Ground_Tile_02_C.png");
        Image[] img = {image1,image2};

        // Create imageview
        // 10 rows at the bottomn
        ImageView[] imageView = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView[i] = new ImageView();
            imageView[i].setImage(image1);
            imageView[i].setFitHeight(70);
            imageView[i].setFitWidth(70);
            imageView[i].setTranslateX(70 * i);
            imageView[i].setTranslateY(700);
        }

        //10 row upwards
        ImageView[] imageView2 = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView2[i] = new ImageView();
            imageView2[i].setImage(image1);
            imageView2[i].setFitHeight(70);
            imageView2[i].setFitWidth(70);
            imageView2[i].setTranslateX(70 * i);
            imageView2[i].setTranslateY(630);
        }

        // y = 560
        ImageView[] imageView3 = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView3[i] = new ImageView();
            imageView3[i].setImage(image1);
            imageView3[i].setFitHeight(70);
            imageView3[i].setFitWidth(70);
            imageView3[i].setTranslateX(70 * i);
            imageView3[i].setTranslateY(560);
        }

        // y = 490
        ImageView[] imageView4 = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView4[i] = new ImageView();
            imageView4[i].setImage(image1);
            imageView4[i].setFitHeight(70);
            imageView4[i].setFitWidth(70);
            imageView4[i].setTranslateX(70 * i);
            imageView4[i].setTranslateY(490);
        }

        // y = 420
        ImageView[] imageView5 = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView5[i] = new ImageView();
            imageView5[i].setImage(image1);
            imageView5[i].setFitHeight(70);
            imageView5[i].setFitWidth(70);
            imageView5[i].setTranslateX(70 * i);
            imageView5[i].setTranslateY(420);
        }

        // y = 350
        ImageView[] imageView6 = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView6[i] = new ImageView();
            imageView6[i].setImage(image1);
            imageView6[i].setFitHeight(70);
            imageView6[i].setFitWidth(70);
            imageView6[i].setTranslateX(70 * i);
            imageView6[i].setTranslateY(350);
        }

        // y = 280
        ImageView[] imageView7 = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView7[i] = new ImageView();
            imageView7[i].setImage(image1);
            imageView7[i].setFitHeight(70);
            imageView7[i].setFitWidth(70);
            imageView7[i].setTranslateX(70 * i);
            imageView7[i].setTranslateY(280);
        }

        // y = 210
        ImageView[] imageView8 = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView8[i] = new ImageView();
            imageView8[i].setImage(image1);
            imageView8[i].setFitHeight(70);
            imageView8[i].setFitWidth(70);
            imageView8[i].setTranslateX(70 * i);
            imageView8[i].setTranslateY(210);
        }

        // y = 140
        ImageView[] imageView9 = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView9[i] = new ImageView();
            imageView9[i].setImage(image1);
            imageView9[i].setFitHeight(70);
            imageView9[i].setFitWidth(70);
            imageView9[i].setTranslateX(70 * i);
            imageView9[i].setTranslateY(140);
        }

        // y = 70
        ImageView[] imageView10 = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView10[i] = new ImageView();
            imageView10[i].setImage(image1);
            imageView10[i].setFitHeight(70);
            imageView10[i].setFitWidth(70);
            imageView10[i].setTranslateX(70 * i);
            imageView10[i].setTranslateY(70);
        }

        // Top position
        ImageView[] imageView11 = new ImageView[20];
        for (int i = 0; i < 20; i++)
        {
            imageView11[i] = new ImageView();
            imageView11[i].setImage(image1);
            imageView11[i].setFitHeight(70);
            imageView11[i].setFitWidth(70);
            imageView11[i].setTranslateX(70 * i);
            imageView11[i].setTranslateY(0);
        }

        tankPane.getChildren().addAll(imageView);
        tankPane.getChildren().addAll(imageView2);
        tankPane.getChildren().addAll(imageView3);
        tankPane.getChildren().addAll(imageView4);
        tankPane.getChildren().addAll(imageView5);
        tankPane.getChildren().addAll(imageView6);
        tankPane.getChildren().addAll(imageView7);
        tankPane.getChildren().addAll(imageView8);
        tankPane.getChildren().addAll(imageView9);
        tankPane.getChildren().addAll(imageView10);
        tankPane.getChildren().addAll(imageView11);
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