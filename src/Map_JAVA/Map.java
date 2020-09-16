package Map_JAVA;

import Tank_JAVA.Tank;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Map extends Application {
    // Constructor
    Scene scene;
    JLabel countdown;
    Timer timer;
    Tank c;


    float second;
    float minute;
    String second2d;
    String minute2d;
    Font font = new Font("Times New Roman",Font.PLAIN,20);
    DecimalFormat format = new DecimalFormat("00");


    public Map() {
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Loading an image");
        // Pane tankPane = new Pane();
        // tankPane.setPrefSize(1400,750);

        Pane tankPane = new Pane();

        Font font = new Font("Times New Roman",Font.PLAIN,20);
        DecimalFormat format = new DecimalFormat("00");

//        pane1.getChildren().add(box);

//        countdown = new JLabel();
//        countdown.setBounds(350,0,100,100);
//        countdown.setHorizontalAlignment(JLabel.CENTER);
//        countdown.setFont(font);

        //Load the map
//        Map = new Map();
        loadGround(tankPane);


        scene = new Scene(tankPane,1565,770);//1400x750
        //Create Player
        c = new Tank(2, 3);
        Group b = new Group();
        b = c.createTank(7);
//        c.createPlayer(0, 0, tankPane, scene, RectList, objectList);
//        Tank c = new Tank(2,4);
//        c.createPlayer(0,700,tankPane,scene,RectList,objectList);
//        Tank a = new Tank (3,1);
//        a.createPlayer(1330,0,tankPane,scene,RectList,objectList);
//        Tank d = new Tank (4,3);
//        d.createPlayer(1330,700,tankPane,scene,RectList,objectList);
        loadObject(tankPane);
        loadLayOut(tankPane);

//        countdown.setText("02:00");
//        second = 0;
//        minute = 0;
        countdownTimer(tankPane);
        //   timer.start();
        //Adding scene to the stage
        stage.setScene(scene);
        stage.show();
    }

    public void loadObject(Pane pane) {

        //Draw object
        //Draw object
        int[][] objectMap = {
                {1, 1, 1, 1, 1, 8, 8, 8, 14, 8, 8, 8, 1, 1, 1, 1, 1, 11, 1, 1},
                {1, 1, 1, 5, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 14, 1, 1},
                {1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8},
                {8, 8, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 8},
                {8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 8},
                {8, 8, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 8, 8},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 8, 8, 8, 14, 8, 8, 8, 1, 1, 1, 1, 1, 1},

        };
        drawObject(pane, objectMap);

        int[][] circleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

        };
        drawCircleObject(pane, circleMap);

        // Draw castle
        int[][] castleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 12, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1},
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
                rect.setStroke(Paint.valueOf("blue"));
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

    public String getImagePath(int choice) {
        switch (choice) {
            case 1:
                return "file:src\\Map_JAVA\\PNG1\\background\\snow.png";
            case 3:
                return "file:src/Map_JAVA/PNG1/background/snow4.png";
            case 4:
                return "file:src/Ultilities/PNG/bigcircle.png";
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
                return "file:src/Map_JAVA/PNG1/object/glass.png";
            case 3:
                return "file:src/Map_JAVA/PNG1/object/boom.png";
            case 4:
                return "file:src/Map_JAVA/PNG1/object/snowman.png";
            case 5:
                return "file:src/Map_JAVA/PNG1/object/reindeer.png";
            case 6:
                return "file:src/Map_JAVA/PNG1/object/socks.png";
            case 7:
                return "file:src/Map_JAVA/PNG1/object/gift.png";
            case 8:
                return "file:src/Map_JAVA/PNG1/object/tree.png";
            case 9:
                return "file:src/Map_JAVA/PNG1/object/penguin2.png";
            case 10:
                return "file:src/Map_JAVA/PNG1/object/santa2.png";
            case 11:
                return "file:src/Map_JAVA/PNG1/object/snowman.png";
            case 12:
                return "file:src/Map_JAVA/PNG1/object/ObjectTree.png";
            case 13:
                return "file:src/Map_JAVA/PNG1/object/Background_Castle.png";
            case 14:
                return "file:src/Map_JAVA/PNG1/object/Puddle.png";
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
            case 6:
                return "file:src\\Map_JAVA\\PNG1\\object\\santa.png";
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
                return "file:src/Map_JAVA/PNG1/object/HouseObject.png";
            case 3:
                return "file:src/Map_JAVA/PNG1/object/snowman2.png";
            case 4:
                return "file:src/Map_JAVA/PNG1/object/tree2.png";
            case 5:
                return "file:src/Map_JAVA/PNG1/object/santa2.png";
            case 6:
                return "file:src/Map_JAVA/PNG1/object/santA/Png";
            case 7:
                return "file:src/Map_JAVA/PNG1/object/penguin2.png";
            case 8:
                return "file:src/Map_JAVA/PNG1/object/penguin.png";
            case 9:
                return "file:src/Map_JAVA/PNG1/object/pine.png";
            case 10:
                return "file:src/Map_JAVA/PNG1/object/tree.png";
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

    public void countdownTimer (Pane tankpane){
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second --;
                second2d = format.format(second);
                minute2d = format.format(minute);
                countdown.setText(second2d + ":" + second2d);
                if (second == -1){
                    second = 59;
                    minute --;
                }
                if(second > 0){
                    second --;
                }
                if (second == 0 && minute ==0){
                    timer.stop();
                }
            }
        });
    }


    int a2 = 10;
    public void loadLayOut (Pane tankPane) throws FileNotFoundException {
        Pane pane1 = new Pane();
        Text a = new Text("Pause");
        a.setX(70);
        a.setY(70);
        a.setTranslateX(1400);
        a.autosize();
        a.setFill(Color.BLACK);
        a.setOnMouseClicked(mouseEvent -> {
            System.out.println("huy cute");
        });
        Rectangle rectangle=new Rectangle(140,70);
        rectangle.setTranslateX(1405);
        rectangle.setFill(Color.CORAL);
        rectangle.setStroke(Color.PINK);
        rectangle.setStrokeWidth(10);
        rectangle.setArcHeight(60);
        rectangle.setArcWidth(60);
        HBox box = new HBox();
        Text text2 = new Text("Player1");
        text2.setTranslateX(1405);
        text2.setFill(Color.BLACK);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(rectangle,text2);
        box.getChildren().addAll(stack);
//        Label label = new Label();
//        label.setText("countdown");
//        label.setPrefSize(140,70);
        Rectangle rectangle2=new Rectangle(140,210);
        rectangle2.setTranslateX(140);
        rectangle2.setTranslateY(210);
        rectangle2.setFill(Color.YELLOW);
        Image image = new Image("file:src/Map_JAVA/PNG4/Background/grass2.png");
        ImageView questionMark = new ImageView(image);
        questionMark.setTranslateX(1450);
        questionMark.setTranslateY(210);
        questionMark.setOnMouseClicked(mouseEvent -> {
            System.out.println("huycute2");
        });
        Image image1 = new Image("file:src/Map_JAVA/PNG4/Background/grass2.png");
        ImageView pauseButton = new ImageView(image1);
        pauseButton.setTranslateX(1450);
        pauseButton.setTranslateY(280);
        pauseButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("huysexy");
        });

        Pane box1 = new Pane();
        box1.setPrefSize(140,770);
        box1.setTranslateX(1430 );
        box1.setTranslateY(50);
        Text text = new Text("Player 1");
        //text1.setTextAlignment(TextAlignment.CENTER);
        text.setTranslateX(1400);
        text.setTranslateY(500);
        text.setFill(Color.BLACK);

        Group player1;
        player1 = c.createTank(5);

        player1.setTranslateX(1400);
        player1.setTranslateY(300);
        box1.getChildren().add(player1);

        ProgressBar huy= new ProgressBar();
        huy.setProgress(a2);
        pane1.getChildren().add(player1);
        //pane1.getChildren().addAll(box,questionMark,pauseButton,player1);
        pane1.setPrefSize(1560,770);
        tankPane.getChildren().add(pane1);
    }

}
