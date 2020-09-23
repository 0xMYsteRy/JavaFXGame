package Map_JAVA;

import Menu_JAVA.MainMenu;
import Menu_JAVA.primaryStage;
import Tank_JAVA.Bot;
import Tank_JAVA.Tank;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Mapboss extends Application {
    // Constructor
    Scene scene;
    Tank c;
    MainMenu mainMenu = new MainMenu();
    private final Integer startTime = 5;
    private Integer seconds = startTime;
    Timeline timeline = new Timeline();
    Label countdown = new Label();
    javafx.scene.text.Font font3 = new javafx.scene.text.Font("Times New Roman",15);
    private int choice;
    private int color;
    Sound sound = new Sound();
    Media media;
    MediaPlayer player;
    public Mapboss(int choice, int color) throws FileNotFoundException {
        c = new Tank(choice,color);
        this.choice = choice;
        this.color = color;
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("SNOWY DOWNY");
        Pane tankPane = new Pane();
        Font font = new Font("Times New Roman",Font.PLAIN,20);
        DecimalFormat format = new DecimalFormat("00");
        loadGround(tankPane);
        javafx.scene.text.Font font2 = new javafx.scene.text.Font("Times New Roman",20);
        scene = new Scene(tankPane,1565,770);//1400x750
        c = new Tank(1, 4);
        c.createPlayer(0, 0, tankPane, scene, RectList, objectList,ObjBotList,null,null,1);
        Tank c = new Tank(1,4);
        loadObject(tankPane);
        loadLayOut(tankPane,stage);
        stage.setScene(scene);
        stage.show();
    }

    public void loadObject(Pane pane) {

        //Draw object
        //Draw object
        int[][] objectMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 18, 1, 1, 1, 18, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 13, 1, 18, 1, 1, 1, 1, 1, 1, 1, 1, 1, 18, 1, 1, 13, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 18, 1, 1, 1, 18, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

        };
        drawObject(pane, objectMap);

        int[][] circleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1 ,1, 1, 1, 11, 1, 1, 1, 1, 1},
                {1, 1, 1, 1,1 , 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

        };
        drawCircleObject(pane, circleMap);

        int[][] circleMap2 = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

        };
        drawCircleObject2(pane, circleMap2);

        // Draw castle
        int[][] castleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        drawCastleObject(pane, castleMap);
    }

    public void loadGround(Pane tankPane) {

        //Draw background
        int[][] pvpMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        drawMap(tankPane, pvpMap);


        //test
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                Rectangle rect = new Rectangle();
                double x = 70 / 9.0;
                rect.setHeight(x * 9);
                rect.setWidth(x * 9);
                rect.setFill(Color.rgb(10, 10, 10, 0));
                rect.setStroke(Paint.valueOf("darkgreen"));
                rect.setTranslateX(70 * j);
                rect.setTranslateY(70 * i);
                tankPane.getChildren().addAll(rect);
            }
        }

    }

    public void drawMap(Pane pane, int[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                String imagePath = getImagePath(map[i][j]);
                ImageView groundCurrent = new ImageView();
                groundCurrent.setImage(new Image(imagePath));
                groundCurrent.setFitHeight(70);
                groundCurrent.setFitWidth(70);
                groundCurrent.setTranslateX(70 * j);
                groundCurrent.setTranslateY(70 * i);
                pane.getChildren().addAll(groundCurrent);
            }
        }
    }

    private final ArrayList<ImageView> objectList = new ArrayList<ImageView>();
    private final ArrayList<Rectangle> RectList = new ArrayList<Rectangle>();
    private ArrayList<Bot> ObjBotList = new ArrayList<>();
    Random random = new Random();

    public void callBot(Pane pane, int[][] map, Tank tank, Scene scene) {
        for (int j = 0; j < 11; j++) {
            for (int i = 0; i < 20; i++) {
                if (map[j][i] > 1) {
                    Bot bot = new Bot(i * 70, j * 70, random.nextInt(4) + 1, random.nextInt(4) + 5, 1, 1);
                    ObjBotList.add(bot);
                    bot.spawnbot(pane, scene, RectList, objectList, tank);
                }
            }
        }
    }

    public ArrayList<Bot> getObjBotList() {
        return ObjBotList;
    }
    public void loadBot(Pane pane, Tank tank, Scene scene) {
        int[][] botSpawn = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

        };
        callBot(pane, botSpawn, tank, scene);
    }
    public String getImagePath(int choice) {
        switch (choice) {
            case 1:
                return "file:src/Map_JAVA/PNG4/Background/grass2.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG4\\ground4.png";
            case 2:
                return "file:src/Map_JAVA/PNG4/Background/ground2.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG4\\ground3.png";
            default:
                return "file:";
        }
    }
    public String getCircleImagePath2(int choice) {
        switch (choice) {
            case 1:
                return "file:";
            case 4:
                return "file:src/Map_JAVA/PNG4/Object/castle2.png";
            case 2:
                return "file:src/Map_JAVA/PNG4/Background/ground2.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG4\\ground3.png";
            default:
                return "file:";
        }
    }

    public String getObjectImagePath(int choice) {
        switch (choice) {
            case 1:
                //return nothing if the no need to add object on that tile.
                return "file:";
            case 2:
                return "file:src/Map_JAVA/PNG4/object/pine.png";
            case 3:
                return "file:src/Map_JAVA/PNG4/object/pine tree.png";
            case 4:
                return "file:src/Map_JAVA/PNG4/object/pine tree 1.png";
            case 5:
                return "file:src/Map_JAVA/PNG4/object/decoration.png";
            case 6:
                return "file:src/Map_JAVA/PNG4/object/direction.png";
            case 7:
                return "file:src/Map_JAVA/PNG4/object/flower.png";
            case 8:
                return "file:src/Map_JAVA/PNG4/object/flower3.png";
            case 9:
                return "file:src/Map_JAVA/PNG4/object/flower3a.png";
            case 10:
                return "file:src/Map_JAVA/PNG4/object/flower3b.png";
            case 11:
                return "file:src/Map_JAVA/PNG4/object/flower4.png";
            case 12:
                return "file:src/Map_JAVA/PNG4/object/flower5.png";
            case 13:
                return "file:src/Map_JAVA/PNG4/object/grass.png";
            case 14:
                return "file:src/Map_JAVA/PNG4/object/jar.png";
            case 15:
                return "file:src/Map_JAVA/PNG4/object/pine.png";
            case 16:
                return "file:src/Map_JAVA/PNG4/object/pine tree.png";
            case 17:
                return "file:src/Map_JAVA/PNG4/object/pine tree 1.png";
            case 18:
                return "file:src/Map_JAVA/PNG4/object/rock.png";
            case 19:
                return "file:src/Map_JAVA/PNG4/object/rock3.png";
            case 20:
                return "file:src/Map_JAVA/PNG4/object/small house.png";
            case 21:
                return "file:src/Map_JAVA/PNG4/object/tomato.png";
            case 22:
                return "file:src/Map_JAVA/PNG4/object/tree.png";
            case 23:
                return "file:src/Map_JAVA/PNG4/object/tree2.png";
            case 24:
                return "file:src/Map_JAVA/PNG4/object/tree7.png";
            case 25:
                return "file:src/Map_JAVA/PNG4/object/tree8.png";
            case 26:
                return "file:src/Map_JAVA/PNG4/object/treee.png";
            case 27:
                return "file:src/Map_JAVA/PNG4/object/windmill.png";
            case 28:
                return  "file:src/Map_JAVA/PNG4/object/wood.png";
            case 29:
                return "file:src/Map_JAVA/PNG4/object/tree10.png";
            case 30:
                return "file:src/Map_JAVA/PNG4/object/treasure.png";
            default:
                return "";
        }
    }

    public void drawObject(Pane pane, int[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                String imagePath = getObjectImagePath(map[i][j]);
                ImageView objectTile = new ImageView();
                objectTile.setImage(new Image(imagePath));
                objectTile.setFitHeight(70);
                objectTile.setFitWidth(70);
                objectTile.setTranslateX(70 * j);
                objectTile.setTranslateY(70 * i);
                pane.getChildren().addAll(objectTile);
                if (map[i][j] > 1) {
                    objectList.add(objectTile);
                }
            }
        }
    }
    // Draw circle
    public String getCircleImagePath(int choice) {
        switch (choice) {
            case 1:
                //return nothing if the no need to add object on that tile.
                return "file:";
            case 2:
                return "file:src/Map_JAVA/PNG4/object/direction.png";
            case 3:
                return "file:src/Map_JAVA/PNG4/object/rock.png";
            case 4:
                return "file:src/Map_JAVA/PNG4/object/rock3.png";
            case 5:
                return "file:src/Map_JAVA/PNG4/object/tree2.png";
            case 6:
                return "file:src/Map_JAVA/PNG4/object/tree10.png";
            case 7:
                return "file:src/Map_JAVA/PNG4/object/tree7.png";
            case 8:
                return "file:src/Map_JAVA/PNG4/object/castle2.png";
            case 9:
                return "file:src/Map_JAVA/PNG4/object/direction2.png";
            case 10:
                return "file:src/Map_JAVA/PNG4/object/direction3.png";
            case 11:
                return "file:src/Map_JAVA/PNG4/object/direction4.png";
            default:
                return "file:";
        }
    }

    public void drawCircleObject(Pane pane, int[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                String imagePath = getCircleImagePath(map[i][j]);
                ImageView CircleTile = new ImageView();
                CircleTile.setImage(new Image(imagePath));
                CircleTile.setScaleX(0.8);
                CircleTile.setScaleY(0.8);
                CircleTile.setFitHeight(140);
                CircleTile.setFitWidth(140);
                CircleTile.setTranslateX(70 * j - 70);
                CircleTile.setTranslateY(70 * i - 70);
                pane.getChildren().addAll(CircleTile);
                if (map[i][j] > 1) {
                    objectList.add(CircleTile);
                }
            }
        }
    }
    public void drawCircleObject2(Pane pane, int[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                String imagePath = getCircleImagePath2(map[i][j]);
                ImageView CircleTile = new ImageView();
                CircleTile.setImage(new Image(imagePath));
                CircleTile.setScaleX(1.75);
                CircleTile.setScaleY(1.75);
                CircleTile.setFitHeight(140);
                CircleTile.setFitWidth(140);
                CircleTile.setTranslateX(70 * j - 70);
                CircleTile.setTranslateY(70 * i - 70);
                pane.getChildren().addAll(CircleTile);
                if (map[i][j] > 1) {
                    objectList.add(CircleTile);
                }
            }
        }
    }

    //Draw Castle
    public String getCastleImagePath(int choice) {
        switch (choice) {
            case 1:
                //return nothing if the no need to add object on that tile.
                return "file:";
            case 2:
                return "file:src/Map_JAVA/PNG4/object/windmill2.png";
            case 3:
                return "file:src/Map_JAVA/PNG4/object/bird statue.png";
            case 4:
                return "file:src/Map_JAVA/PNG4/object/castle 3.png";
            case 5:
                return "file:src/Map_JAVA/PNG4/object/direction.png";
            case 6:
                return "file:src/Map_JAVA/PNG4/object/castle.png";
            case 7:
                return "file:src/Map_JAVA/PNG4/object/wood mine.png";
            case 8:
                return "file:src/Map_JAVA/PNG4/object/gold mine.png";
            case 9:
                return "file:src/Map_JAVA/PNG4/object/chimmey.png";
            case 10:
                return "file:src/Map_JAVA/PNG4/object/fountain.png";
            case 11:
                return "file:src/Map_JAVA/PNG1/object/gift.png";
            case 12:
                return "file:src/Map_JAVA/PNG1/object/reindeer.png";
            default:
                return "file:";
        }
    }

    public ArrayList<Rectangle> getRectList() {
        return RectList;
    }

    public ArrayList<ImageView> getobjectList() {
        return objectList;
    }

    public void drawCastleObject(Pane pane, int[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                String imagePath = getCastleImagePath(map[i][j]);
                ImageView CastleTile = new ImageView();
                Rectangle rect = new Rectangle();

                CastleTile.setImage(new Image(imagePath));
                CastleTile.setScaleX(1.5);
                CastleTile.setScaleY(1.5);
                CastleTile.setFitHeight(140);
                CastleTile.setFitWidth(140);
                CastleTile.setTranslateX(70 * j - 70);
                CastleTile.setTranslateY(70 * i - 35);
                pane.getChildren().addAll(CastleTile);
                if (map[i][j] > 1) {
                    double x = 70 / 9.0;
                    rect.setHeight(x * 9);
                    rect.setWidth(x * 9 * 2);
                    rect.setFill(Color.rgb(10, 10, 10, 0));
                    rect.setStroke(Color.rgb(10, 10, 10, 0));
                    rect.setTranslateX(70 * j - 70);
                    rect.setTranslateY(70 * i + 70);
                    pane.getChildren().addAll(rect);
                    RectList.add(rect);
                }
            }
        }
    }

    public void doTime(Pane tankPane, Stage stage) {
        Timeline time= new Timeline();
        sound.loadSound(5);

//        media = new Media(sound.getSound(1));
//        player = new MediaPlayer(media);
//        player.setCycleCount(MediaPlayer.INDEFINITE);
//        player.play();
        KeyFrame frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {


                seconds--;
                DecimalFormat df = new DecimalFormat("00");
                String sec = df.format(seconds);
                countdown.setText("Times \n"+ "00"+":"+ sec);
                countdown.setTranslateX(30);
                countdown.setTranslateY(10);
                countdown.setTextFill(Color.SNOW);
                countdown.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.EXTRA_BOLD,25));

                if(seconds <= 0){
                    time.stop();
                    sound.stopSound();
                    //sound.loadSound(7);


                    Label label = new Label();
                    label.setText("GAME OVER");
                    label.setTextFill(Color.FIREBRICK);
                    javafx.scene.text.Font font = new javafx.scene.text.Font("Times New Roman",100);
                    label.setFont(font);
                    label.setTranslateX(430);
                    label.setTranslateY(300);
                    Pane pane = new Pane();
                    pane.getChildren().add(label);
                    ColorAdjust colorAdjust = new ColorAdjust();
                    colorAdjust.setContrast(2);
                    tankPane.setEffect(colorAdjust);
                    pane.setEffect(new Glow(2.5));
                    Label playAgain = new Label("Play Again");
                    playAgain.setTranslateX(600);
                    playAgain.setTranslateY(450);
                    playAgain.setFont(javafx.scene.text.Font.font("Times New Roman", FontPosture.ITALIC,50));
                    playAgain.setTextFill(Color.MEDIUMBLUE);
                    playAgain.setOnMouseClicked(event1 -> {
                        try {
                            primaryStage.setScene(4);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    });

                    Label exit = new Label("Exit");
                    exit.setTextFill(Color.MEDIUMBLUE);
                    exit.setTranslateX(600);
                    exit.setTranslateY(520);
                    exit.setFont(javafx.scene.text.Font.font("Times New Roman", FontPosture.ITALIC,50));
                    exit.setOnMouseClicked(event2 -> {
                        try {
                            primaryStage.setScene(5);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                    tankPane.getChildren().addAll(pane,playAgain,exit);

                    Label victory = new Label("Victory");
                    victory.setTextFill(Color.FIREBRICK);
                    victory.setFont(font);
                    victory.setTranslateX(430);
                    victory.setTranslateY(300);
                    Pane pane2 = new Pane();
                    pane2.getChildren().add(victory);
                    pane2.setEffect(new Glow(2.5));
                    tankPane.getChildren().add(pane2);

                }


            }


        });

        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        if(time!=null){
            time.stop();
        }
        time.playFromStart();


    }

    public void loadLayOut (Pane tankPane, Stage stage) throws FileNotFoundException {
        Pane pane1 = new Pane();


        doTime(tankPane,stage);

//        Rectangle rectangle=new Rectangle(120,70);
//        rectangle.setTranslateX(1407);
//        rectangle.setTranslateY(20);
//        rectangle.setFill(Color.CORAL);
//        rectangle.setStroke(Color.ORANGERED);
//        rectangle.setStrokeWidth(5);
//        rectangle.setArcHeight(60);
//        rectangle.setArcWidth(60);
        VBox box = new VBox();
        box.setTranslateX(1410);
        box.setTranslateY(0);
        box.setPrefSize(140,70);
//        Text text2 = new Text("Time");
//        text2.setTranslateX(1405);
//        text2.setFill(Color.GRAY);
        box.getChildren().addAll(countdown);
//        Label label = new Label();
//        label.setText("countdown");
        //    label.setPrefSize(140,70);
        Rectangle rectangle2=new Rectangle(140,770);
        rectangle2.setTranslateX(1400);
        rectangle2.setFill(Color.OLIVEDRAB);
        rectangle2.setStroke(Color.DARKGREEN);
           rectangle2.setArcHeight(60);
        rectangle2.setArcWidth(60);
        rectangle2.setStrokeWidth(10);
        Image image = new Image("file:src/Map_JAVA/PNG1/QuestionButton.png");
        ImageView questionMark = new ImageView(image);
        questionMark.setTranslateX(1435);
        questionMark.setTranslateY(100);
        questionMark.setOnMouseClicked(mouseEvent -> {
            System.out.println("huycute2");
        });
        Image image1 = new Image("file:src/Map_JAVA/PNG1/pause button.png");
        ImageView pauseButton = new ImageView(image1);
        pauseButton.setTranslateX(1435);
        pauseButton.setTranslateY(200);
        pauseButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("huysexy");
        });

        HBox box1 = new HBox();
        box1.setPrefSize(140,770);
        box1.setTranslateX(1430 );
        box1.setTranslateY(50);
        Text text = new Text("Player 1");
        text.setTextAlignment(TextAlignment.CENTER);
//        text.setTranslateX(1450);
//        text.setTranslateY(320);
        text.setFill(Color.SNOW);

        text.setFont(javafx.scene.text.Font.font("Times New Roman",FontWeight.BOLD,15));
//        Tank test = new Tank(1,2);
        Group player1 = new Group();
        player1 = c.createTank(5);
        player1.setTranslateX(1400);
        player1.setTranslateY(300);

//        TextField textField = new TextField("Score");
//        textField.setFont(font3);
 //        textField.setPrefSize(90,15);
//        textField.setText("Score");
//        textField.setAlignment(Pos.CENTER_LEFT);
//        textField.setTranslateX(1450);
//        textField.setTranslateY(340);
        VBox box2 = new VBox();
        box2.setTranslateX(1450);
        box2.setTranslateY(300);
        box2.getChildren().addAll(text);

        ProgressBar health = new ProgressBar();
        health.setProgress(1);
        health.setPrefSize(80,20);
        ColorInput colorInput2 = new ColorInput();
        colorInput2.setPaint(Color.RED);
        health.setStyle("-fx-accent: RED");
        Label health2 = new Label();
        health2.setText("Health");
        health2.setFont(font3);

        health2.setTextFill(Color.SNOW);
        Label label = new Label("Enemy\nRemains");
        label.setTextFill(Color.SNOW);
        label.setTranslateX(1410);
        label.setTranslateY(400);
        label.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.EXTRA_BOLD,15));

        Label score = new Label("Score");
        score.setTextFill(Color.SNOW);
        score.setTranslateX(1440);
        score.setTranslateY(460);
        score.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.EXTRA_BOLD,FontPosture.ITALIC,30));

        HBox box4 = new HBox();
        box4.setPrefSize(140,30);
        box4.setTranslateX(1410);
        box4.setTranslateY(350);
        box4.getChildren().addAll(health2,health);

//        box3.getChildren().add(textField);
        //box1.getChildren().add(player1);

//        ProgressBar huy;
//        huy.setProgress(a2);
        // pane1.getChildren().add(player1);
        pane1.getChildren().addAll(rectangle2,box,questionMark,pauseButton);
        pane1.setPrefSize(1560,770);
        tankPane.getChildren().addAll(pane1,player1,box2,box4,label,score);
        //tankPane.getChildren().add(box3);


    }

}
