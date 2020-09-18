package Map_JAVA;

import Menu_JAVA.MainMenu;
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
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class   Map3 extends Application {
    // Constructor
    Scene scene;
    Tank c;
    MainMenu mainMenu = new MainMenu();
    private final Integer startTime = 10;
    private Integer seconds = startTime;
    Timeline timeline = new Timeline();
    Label countdown = new Label();
    javafx.scene.text.Font font3 = new javafx.scene.text.Font("Times New Roman",15);


    public Map3() throws FileNotFoundException {
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Mianmi beach");
        // Pane tankPane = new Pane();
        // tankPane.setPrefSize(1400,750);

        Pane tankPane = new Pane();

        Font font = new Font("Times New Roman",Font.PLAIN,20);
        DecimalFormat format = new DecimalFormat("00");

//        pane1.getChildren().add(box);


        //Load the map
//        Map = new Map();
        loadGround(tankPane,stage);
        javafx.scene.text.Font font2 = new javafx.scene.text.Font("Times New Roman",20);

        scene = new Scene(tankPane,1565,770);//1400x750
        //Create Player
        c = new Tank(1, 4);

        c.createPlayer(0, 0, tankPane, scene, RectList, objectList,ObjBotList,1);
        Tank c = new Tank(1,4);

        loadObject(tankPane);
     //   loadLayOut(tankPane,stage);
     loadBot(tankPane,c,scene);
//        countdown.setText("02:00");
//        second = 0;
//        minute = 0;
        //   timer.start();
        //Adding scene to the stage
        stage.setScene(scene);
        stage.show();
    }



    private final ArrayList<ImageView> objectList = new ArrayList<ImageView>();
    private final ArrayList<Rectangle> RectList = new ArrayList<Rectangle>();

    public ArrayList<Rectangle> getRectList() {
        return RectList;
    }

    public ArrayList<ImageView> getobjectList() {
        return objectList;
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
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

        };
        callBot(pane, botSpawn, tank, scene);
    }
    public void loadGround(Pane tankPane, Stage stage) {

        //Draw background
        int[][] pvpMap = {
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3},
                {1, 3, 3, 1, 4, 1, 1, 2, 1, 3, 1, 3, 3, 2, 3, 2, 1, 2, 3, 1},
                {2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2},
                {1, 4, 1, 2, 3, 3, 1, 4, 4, 2, 2, 1, 1, 1, 1, 4, 1, 4, 2, 2},
                {2, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},
                {2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2},
                {9, 1, 1, 1, 1, 1, 1, 11, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        };
        drawMap(tankPane, pvpMap);
//        for (int i = 0; i < 11; i++) {
//            for (int j = 0; j < 20; j++) {
//                Rectangle rect = new Rectangle();
//                double x = 70 / 9.0;
//                rect.setHeight(x * 9);
//                rect.setWidth(x * 9);
//                rect.setFill(Color.rgb(10, 10, 10, 0));
//                rect.setStroke(Paint.valueOf("lightblue"));
//                rect.setTranslateX(70 * j);
//                rect.setTranslateY(70 * i);
//                tankPane.getChildren().addAll(rect);
//            }
//        }

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
            rectangle2.setFill(Color.SIENNA);
            rectangle2.setStroke(Color.SADDLEBROWN);
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
            Image image1 = new Image("file:src\\Map_JAVA\\PNG1\\pause button.png");
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

            Tank c;
            c = new Tank(1,4);
            Group player1;
            player1 = c.createTank(5,1);
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

    public void loadObject(Pane tankPane){

        //  Draw object
        int[][] objectMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 16, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 26, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 22, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 8, 1, 1, 1, 14, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 9, 1, 1},
                {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 15, 1, 1, 1, 1, 1, 1},
        };
        drawObject(tankPane, objectMap);

        // Draw Circle
        int[][] objectMap2 = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        drawObject2(tankPane, objectMap2);

        // Draw castle
        int[][] castleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        drawCastleObject(tankPane, castleMap);
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

    public String getImagePath(int choice) {
        switch (choice) {
            case 1:
                return "file:src/Map_JAVA/PNG3/Background/beach.png";
            case 2:
                return "file:src/Map_JAVA/PNG3/Background/beach2.png";
            case 3:
                return "file:src/Map_JAVA/PNG3/Background/beach3.png";
            case 4:
                return "file:src/Map_JAVA/PNG3/Background/grass.png";
            case 5:
                return "file:src/Map_JAVA/PNG3/Background/beacha.png";
            case 6:
                return "file:src/Map_JAVA/PNG3/Background/beachb.png";
            case 7:
                return "file:src/Map_JAVA/PNG3/Background/beachc.png";
            case 8:
                return "file:src/Map_JAVA/PNG3/Background/sea.png";
            case 9:
                return "file:src/Map_JAVA/PNG3/Background/seax.png";
            case 10:
                return "file:src/Map_JAVA/PNG3/Background/seay.png";
            case 11:
                return "file:src/Map_JAVA/PNG3/Background/seaz.png";

            default:
                return "";
        }
    }

    public String getObjectImagePath(int choice) {
        switch (choice) {
            case 1:
                //return nothing if the no need to add object on that tile.
                return "file:";
            case 2:
                return "file:src/Map_JAVA/PNG3/Object/ball.png";
            case 3:
                return "file:src/Map_JAVA/PNG3/Object/ball1.png";
            case 4:
                return "file:src/Map_JAVA/PNG3/Object/ball2.png";
            case 5:
                return "file:src/Map_JAVA/PNG3/Object/ball3.png";
            case 6:
                return "file:src/Map_JAVA/PNG3/Object/crab.png";
            case 7:
                return "file:src/Map_JAVA/PNG3/Object/fins.png";
            case 8:
                return "file:src/Map_JAVA/PNG3/Object/float.png";
            case 9:
                return "file:src/Map_JAVA/PNG3/Object/float2.png";
            case 10:
                return "file:src/Map_JAVA/PNG3/Object/ipod.png";
            case 11:
                return "file:src\\Map_JAVA\\PNG3\\Object\\shell.png";
            case 12:
                return "file:src/Map_JAVA/PNG3/Object/ship.png";
            case 13:
                return "file:src\\Map_JAVA\\PNG3\\Object\\ship2.png";
            case 14:
                return "file:src/Map_JAVA/PNG3/Object/starfish.png";
            case 15:
                return "file:src/Map_JAVA/PNG3/Object/starfish2.png";
            case 16:
                return "file:src/Map_JAVA/PNG3/Object/surfboard.png";
            case 17:
                return "file:src/Map_JAVA/PNG3/Object/umbrella3.png";
            case 18:
                return "file:src/Map_JAVA/PNG3/Object/umbrella2.png";
            case 19:
                return "file:src/Map_JAVA/PNG3/Object/umbrella.png";
            case 20:
                return "file:src/Map_JAVA/PNG3/Object/shell.png";
            case 21:
                return "file:src/Map_JAVA/PNG3/Object/showel.png";
            case 22:
                return "file:src/Map_JAVA/PNG3/Object/star fish 2.png";
            case 23:
                return "file:src/Map_JAVA/PNG3/Object/tube.png";
            case 24:
                return "file:src/Map_JAVA/PNG3/Object/umbrella.png";
            case 25:
                return "file:src/Map_JAVA/PNG3/Object/umbrella2.png";
            case 26:
                return "file:src/Map_JAVA/PNG3/Object/sandal.png";
            case 27:
                return "file:src/Map_JAVA/PNG3/Object/whale.png";
            case 28:
                return "file:src/Map_JAVA/PNG3/Object/sunglasses.png";
            case 29:
                return "file:src/Map_JAVA/PNG3/Object/coconut tree 5.png";

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
                return "file:src/Map_JAVA/PNG3/Object/boat4.png";
            case 3:
                return "file:src/Map_JAVA/PNG3/Object/tree.png";
            case 5:
                return "file:src/Map_JAVA/PNG3/Object/tree2.png";
            case 4:
                return "file:src/Map_JAVA/PNG3/Object/coconut tree 5.png";
            case 6:
                return "file:src/Map_JAVA/PNG3/Object/umbrella combo.png";
            case 7:
                return "file:src/Map_JAVA/PNG3/Object/boat2.png";
            case 8:
                return "file:src/Map_JAVA/PNG3/Object/big chair.png";
            case 9:
                return "file:src/Map_JAVA/PNG3/Object/castle.png";
            case 10:
                return "file:src/Map_JAVA/PNG3/Object/sand.png";
            case 11:
                return "file:src/Map_JAVA/PNG3/Object/showel.png";
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
                CastleTile.setScaleX(1.5);
                CastleTile.setScaleY(1.5);
                CastleTile.setFitHeight(150);
                CastleTile.setFitWidth(150);
                CastleTile.setTranslateX(70 * j - 70);
                CastleTile.setTranslateY(70 * i - 70);
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

    // Draw circle
    public String getCircleImagePath(int choice) {
        switch (choice) {
            case 1:
                //return nothing if the no need to add object on that tile.
                return "file:";
            case 2:
                return "file:src/Map_JAVA/PNG3/Object/showel.png";
            case 3:
                return "file:src/Map_JAVA/PNG3/Object/castle.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG3\\Object\\ship2.png";
            case 5:
                return "file:src/Map_JAVA/PNG3/Object/umbrella3.png";
            case 6:
                return "file:src/Map_JAVA/PNG3/Object/umbrella.png";
            case 7:
                return "file:src/Map_JAVA/PNG3/Object/umbrella2.png";
            case 8:
                return "file:src/Map_JAVA/PNG3/Object/ship.png";
            default:
                return "file:";
        }
    }

    public void drawObject2(Pane pane, int[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                String imagePath = getCircleImagePath(map[i][j]);
                ImageView CircleTile = new ImageView();
                CircleTile.setImage(new Image(imagePath));
                CircleTile.setScaleX(1.5);
                CircleTile.setScaleY(1.5);
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
    public void doTime(Pane tankPane, Stage stage) {
        Timeline time= new Timeline();


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
                    tankPane.getChildren().add(pane);
                    Label newGame = new Label("New Game");
                    newGame.setTranslateX(600);
                    newGame.setTranslateY(450);
                    newGame.setFont(javafx.scene.text.Font.font("Times New Roman", FontPosture.ITALIC,50));
                    newGame.setTextFill(Color.BLACK);

                    Label exit = new Label("Exit");
                    exit.setTextFill(Color.BLACK);
                    exit.setTranslateX(660);
                    exit.setTranslateY(520);
                    tankPane.getChildren().addAll(newGame,exit);
                    exit.setFont(javafx.scene.text.Font.font("Times New Roman", FontPosture.ITALIC,50));
                    exit.setOnMouseClicked(event2 -> {
                        try {
                            stage.setScene(new Scene(mainMenu.createContent()));
                            stage.show();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                    newGame.setOnMouseClicked(event1 -> {
                        stage.close();
                        Platform.runLater( () -> {
                            try {
                                new Map3().start( new Stage() );
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                    });

                    stage.setScene(scene);
                    stage.show();
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


}

