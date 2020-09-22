package Map_JAVA;

import Menu_JAVA.MainMenu;
import Menu_JAVA.primaryStage;
import Scene_JAVA.Scene_Map1;
import Tank_JAVA.Bot;
import Tank_JAVA.Tank;
import javafx.animation.Animation;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;


public class MapPVP  {
    // Constructor
    Scene scene;
    Tank tank;
    Stage stage = new Stage();
    MainMenu mainMenu = new MainMenu();
    private final Integer startTime = 60;
    private Integer seconds = startTime;
    Timeline timeline = new Timeline();
    Label countdown = new Label();
    javafx.scene.text.Font font3 = new javafx.scene.text.Font("Times New Roman", 15);
    Map2 map2 = new Map2();

    public MapPVP() throws FileNotFoundException {
    }


    private final ArrayList<ImageView> objectList = new ArrayList<ImageView>();
    private final ArrayList<Rectangle> RectList = new ArrayList<Rectangle>();

    public void loadGround(Pane tankPane) {

        //Draw background
        int[][] pvpMap = {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2},
                {2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2},
                {2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2},
        };
        drawMap(tankPane, pvpMap);
    }

    //  Draw object
    public void loadObject(Pane pane) {
        int[][] objectMap = {
                {1, 1, 8, 8, 13, 1, 1, 1, 26, 8, 1, 3, 1, 11, 8, 1, 7, 15, 1, 1},
                {1, 1, 7, 7, 1, 6, 1, 10, 10, 8, 11, 7, 1, 1, 31, 1, 13, 11, 1, 1},
                {10, 10, 27, 1, 26, 1, 1, 1, 13, 7, 7, 1, 13, 1, 1, 3, 1, 11, 8, 1},
                {11, 18, 1, 30, 1, 1, 1, 1, 1, 8, 3, 1, 1, 1, 1, 1, 30, 1, 13, 10},
                {15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 26},
                {1, 15  , 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 27},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {8, 8, 1, 24, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 29, 1, 13, 8},
                {1, 7, 15, 1, 25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 31, 1, 10, 11, 1},
                {1, 1, 10, 4, 1, 26, 1, 1, 1, 1, 1, 1, 1, 1, 15, 1, 1, 10, 1, 1},
                {1, 1, 7, 11, 1, 1, 29, 1, 32, 32, 32, 32, 1, 28, 1, 26, 11, 15, 1, 1},
        };
        drawObject(pane, objectMap);

        // Draw Circle
        int[][] circleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        drawCircleObject(pane, circleMap);

        // Draw castle
        int[][] castleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        drawCastleObject(pane, castleMap);
    }

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
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                Rectangle rect = new Rectangle();
                double x = 70 / 9.0;
                rect.setHeight(x * 9);
                rect.setWidth(x * 9);
                rect.setFill(Color.rgb(10, 10, 10, 0));
                rect.setStroke(Paint.valueOf("green"));
                rect.setTranslateX(70 * j);
                rect.setTranslateY(70 * i);
                pane.getChildren().addAll(rect);
            }
        }
    }

    public String getImagePath(int choice) {
        switch (choice) {
            case 1:
                return "file:src/Map_JAVA/PNG2/Background/glassground2.png";
            case 2:
                return "file:src/Map_JAVA/PNG2/Background/glass ground .png";
            case 3:
                return "file:src/Map_JAVA/PNG2/object/bigcircle.png";
            default:
                return "";
        }
    }

    public ArrayList<Rectangle> getRectList() {
        return RectList;
    }

    public ArrayList<ImageView> getobjectList() {
        return objectList;
    }

    public String getObjectImagePath(int choice) {
        switch (choice) {
            case 1:
                //return nothing if the no need to add object on that tile.
                return "file:";
            case 2:
                return "file:src/Map_JAVA/PNG2/object/strawman.png";
            case 3:
                return "file:src/Map_JAVA/PNG2/object/straw2.png";
            case 4:
                return "file:src/Map_JAVA/PNG2/object/mushroom.png";
            case 5:
                return "file:src/Map_JAVA/PNG2/object/flowers.png";
            case 6:
                return "file:src/Map_JAVA/PNG2/object/barrel.png";
            case 7:
                return "file:src/Map_JAVA/PNG2/object/smaltree2.png";
            case 8:
                return "file:src/Map_JAVA/PNG2/object/smalltree4.png";
            case 9:
                return "file:src/Map_JAVA/PNG2/object/bigmountain.png";
            case 10:
                return "file:src/Map_JAVA/PNG2/object/smalltree3.png";
            case 11:
                return "file:src/Map_JAVA/PNG2/object/smalltree1.png";
            case 12:
                return "file:src/Map_JAVA/PNG2/object/smallhouse2.png";
            case 13:
                return "file:src/Map_JAVA/PNG2/object/rock.png";
            case 14:
                return "file:src/Map_JAVA/PNG2/object/smallhouse.png";
            case 15:
                return "file:src/Map_JAVA/PNG2/object/spawnposition.png";
            case 16:
                return "file:src/Map_JAVA/PNG4/Object/flower4.png";
            case 17:
                return "file:src/Map_JAVA/PNG2/object/rock.png";
            case 18:
                return "file:src/Map_JAVA/PNG2/object/rock.png";
            case 19:
                return "file:src/Map_JAVA/PNG4/Object/flower3a.png";
            case 26:
                return "file:src/Map_JAVA/PNG4/Object/grass.png";
            case 21:
                return "file:src/Map_JAVA/PNG2/object/rock3.png";
            case 22:
                return "file:src/Map_JAVA/PNG2/object/rock4.png";
            case 23:
                return "file:src/Map_JAVA/PNG2/object/barn.png";
            case 24:
                return "file:src/Map_JAVA/PNG2/Object/rock.png";
            case 25:
                return "file:src/Map_JAVA/PNG2/Object/pig.png";
            case 20:
                return "file:src/Map_JAVA/PNG4/Object/flower.png";
            case 27:
                return "file:src/Map_JAVA/PNG2/Object/hens.png";
            case 28:
                return "file:src/Map_JAVA/PNG2/Object/duck.png";
            case 29:
                return "file:src/Map_JAVA/PNG2/Object/deer.png";
            case 30:
                return "file:src/Map_JAVA/PNG2/Object/bird.png";
            case 31:
                return "file:src/Map_JAVA/PNG2/Object/pig2.png";
            case 32:
                return "file:src/Map_JAVA/PNG2/Object/wheat.png";


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

    //Draw Castle
    public String getCastleImagePath(int choice) {
        switch (choice) {
            case 1:
                //return nothing if the no need to add object on that tile.
                return "file:";
            case 2:
                return "file:src/Map_JAVA/PNG2/object/straw2.png";
            case 3:
                return "file:src/Map_JAVA/PNG2/object/windmill.png";
            case 5:
                return "file:src/Map_JAVA/PNG2/object/house4.png";
            case 4:
                return "file:src/Map_JAVA/PNG4/Object/fountain.png";
            default:
                return "";
        }
    }


    public void drawCastleObject(Pane pane, int[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                String imagePath = getCastleImagePath(map[i][j]);
                ImageView CastleTile = new ImageView();
                Rectangle rect = new Rectangle();
                CastleTile.setImage(new Image(imagePath));
                CastleTile.setScaleX(1.75);
                CastleTile.setScaleY(1.75);
                CastleTile.setFitHeight(175);
                CastleTile.setFitWidth(175);
                CastleTile.setTranslateX(70 * j - 70);
                CastleTile.setTranslateY(70 * i - 70);
                pane.getChildren().addAll(CastleTile);
                if (map[i][j] > 1) {
                    double x = 70 / 9.0;
                    rect.setHeight(x * 9);
                    rect.setWidth(x * 9 * 2);
                    rect.setFill(javafx.scene.paint.Color.rgb(10, 10, 10, 0));
                    rect.setStroke(Color.rgb(10, 10, 10, 0));
                    rect.setTranslateX(70 * j - 70);
                    rect.setTranslateY(70 * i + 70);
                    pane.getChildren().addAll(rect);
                    RectList.add(rect);
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
                return "file:src/Map_JAVA/PNG2/object/bigcircle.png";
            case 3:
                return "file:src/Map_JAVA/PNG4/Object/chimmey.png";
            case 5:
                return "file:src/Map_JAVA/PNG4/Object/fountain.png";
            case 4:
                return "file:src/Map_JAVA/PNG2/Object/barn2.png";
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
                CircleTile.setScaleX(1.75);
                CircleTile.setScaleY(1.75);
                CircleTile.setFitHeight(150);
                CircleTile.setFitWidth(150);
                CircleTile.setTranslateX(70 * j - 70);
                CircleTile.setTranslateY(70 * i - 70);
                pane.getChildren().addAll(CircleTile);
                if (map[i][j] > 1) {
                    objectList.add(CircleTile);
                }
            }
        }
    }

    public void doTime(Pane tankPane,Stage stage) {
        Timeline time = new Timeline();
        Sound sound = new Sound();
        sound.loadSound(4);

        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {


                seconds--;
                DecimalFormat df = new DecimalFormat("00");
                String sec = df.format(seconds);
                countdown.setText("Times \n" + "00" + ":" + sec);
                countdown.setTranslateX(30);
                countdown.setTranslateY(10);
                countdown.setTextFill(Color.SNOW);
                countdown.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 25));

                if (seconds <= 0) {
                    time.stop();
                    sound.stopSound();
                    Label label = new Label();
                    label.setText("GAME OVER");
                    label.setTextFill(Color.FIREBRICK);
                    javafx.scene.text.Font font = new javafx.scene.text.Font("Times New Roman", 100);
                    label.setFont(font);
                    label.setTranslateX(430);
                    label.setTranslateY(300);
                    Pane pane = new Pane();
                    pane.getChildren().add(label);
                    ColorAdjust colorAdjust = new ColorAdjust();
                    colorAdjust.setHue(1);
                    tankPane.setEffect(colorAdjust);
                    pane.setEffect(new Glow(2.5));
                    tankPane.getChildren().add(pane);
                    Label newGame = new Label("New Game");
                    newGame.setTranslateX(600);
                    newGame.setTranslateY(450);
                    newGame.setFont(javafx.scene.text.Font.font("Times New Roman", FontPosture.ITALIC, 50));
                    newGame.setTextFill(Color.MEDIUMBLUE);

                    Label exit = new Label("Exit");
                    exit.setTextFill(Color.MEDIUMBLUE);
                    exit.setTranslateX(650);
                    exit.setTranslateY(590);
                    exit.setFont(javafx.scene.text.Font.font("Times New Roman", FontPosture.ITALIC, 50));
                    exit.setOnMouseClicked(event2 -> {
                        try {
                            stage.setScene(new Scene(mainMenu.createContent()));
                            stage.show();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    });

                    Label nextLevel = new Label("Next Level");
                    nextLevel.setTextFill(Color.MEDIUMBLUE);
                    nextLevel.setTranslateX(600);
                    nextLevel.setTranslateY(520);
                    nextLevel.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD,FontPosture.ITALIC,50));
                    nextLevel.setOnMouseClicked(event3 ->{
                        try {
                            Scene_Map1 scene_map1 = new Scene_Map1();
                            primaryStage.getStage().setScene(scene_map1.setScene1(stage));
                            System.out.println("loadmap");
                            System.out.println("loaded");
                        } catch (Exception e) {
                            e.printStackTrace();
                        };
                    });
                    tankPane.getChildren().addAll(newGame,nextLevel,exit);
                    newGame.setOnMouseClicked(event1 -> {

                    });


                }


            }


        });

        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        if (time != null) {
            time.stop();
        }
        time.playFromStart();


    }

    ProgressBar health = new ProgressBar();
    double initialHealth;
    double currentHealth;
    public void setHealth() {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100),
                actionEvent -> {
                    currentHealth = tank.getHealth();
                    double valueHealth = currentHealth / initialHealth;
                    this.health.setProgress(valueHealth);
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setOnFinished(actionEvent -> {
            if (currentHealth<=0){
                timeline.stop();
            }
        });
        timeline.play();


    }

    public void loadLayOut(Pane tankPane, Stage stage, Tank tank) throws FileNotFoundException {
        this.tank = tank;
        initialHealth = tank.getHealth();
        Pane pane1 = new Pane();
        doTime(tankPane,stage);
        VBox box = new VBox();
        box.setTranslateX(1410);
        box.setTranslateY(0);
        box.setPrefSize(140, 70);
        box.getChildren().addAll(countdown);
        Rectangle rectangle2 = new Rectangle(140, 770);
        rectangle2.setTranslateX(1400);
        rectangle2.setFill(Color.DARKGOLDENROD);
        rectangle2.setStroke(Color.GOLDENROD);
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
        box1.setPrefSize(140, 770);
        box1.setTranslateX(1430);
        box1.setTranslateY(50);
        Text text = new Text("Player 1");
        text.setTextAlignment(TextAlignment.CENTER);
//        text.setTranslateX(1450);
//        text.setTranslateY(320);
        text.setFill(Color.SNOW);
        text.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.BOLD, 15));
        Tank b;
        b = new Tank(1, 4);
        Group player2;
        player2 = b.createTank(5);
        player2.setTranslateX(1400);
        player2.setTranslateY(300);

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
        health.setProgress(1);
        setHealth();
        health.setPrefSize(80, 20);
        ColorInput colorInput2 = new ColorInput();
        colorInput2.setPaint(Color.RED);
        health.setStyle("-fx-accent: RED");
        javafx.scene.control.Label health2 = new javafx.scene.control.Label();
        health2.setText("Health");
        health2.setFont(font3);

        health2.setTextFill(Color.SNOW);
        javafx.scene.control.Label label = new Label("Enemy\nRemains");
        label.setTextFill(Color.SNOW);
        label.setTranslateX(1410);
        label.setTranslateY(400);
        label.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));

        Label score = new Label("Score");
        score.setTextFill(Color.SNOW);
        score.setTranslateX(1440);
        score.setTranslateY(460);
        score.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 30));

        HBox box4 = new HBox();
        box4.setPrefSize(140, 30);
        box4.setTranslateX(1410);
        box4.setTranslateY(350);
        box4.getChildren().addAll(health2, health);

//        box3.getChildren().add(textField);
        //box1.getChildren().add(player1);

//        ProgressBar huy;
//        huy.setProgress(a2);
        // pane1.getChildren().add(player1);
        pane1.getChildren().addAll(rectangle2, box, questionMark, pauseButton);
        pane1.setPrefSize(1560, 770);
        tankPane.getChildren().addAll(pane1, player2, box2, box4, label, score);
        //tankPane.getChildren().add(box3);


    }


}



