package Map_JAVA;

import Tank_JAVA.Tank;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;


public class   Map2 extends Application {
    // Constructor
    Scene scene;
    public Map2() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Beach");
        Pane tankPane;
        tankPane = new Pane();
        Map2 map2 = new Map2();
        map2.loadGround(tankPane);
        map2.loadObject(tankPane);
        scene = new Scene(tankPane,1400,750);
        Tank c = new Tank(3,1);
//        c.createPlayer(70,70,tankPane,scene,RectList,objectList);
        stage.setScene(scene);
        stage.show();
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
    public void loadObject (Pane pane){
        int[][] objectMap = {
                {1, 1, 8, 8, 13, 1, 9, 1, 1, 8, 1, 3, 1, 11, 8, 1, 7, 15, 1, 1},
                {1, 1, 7, 7, 1, 6, 1, 10, 10, 8, 11, 7, 1, 1, 14, 1, 13, 11, 1, 1},
                {10, 10, 1, 13, 1, 1, 1, 1, 13,7 , 7, 1, 13, 1, 1, 3, 1, 11, 8, 1},
                {11, 11, 18, 1, 1, 1, 1, 1, 1, 8, 3, 1, 1, 1, 1, 1, 1, 1, 13, 10},
                {15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5},
                {1, 15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {8, 8, 1, 24, 1, 1, 1, 1, 1, 1, 1,1, 1, 1, 1, 12, 3, 1, 13, 8},
                {1, 7, 15, 1, 25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 16, 10, 11, 1},
                {1, 1, 10, 4, 1, 20, 1, 1, 1, 1, 1, 1, 1, 1, 15, 2, 1, 10, 1, 1},
                {1, 1, 7, 11, 1, 1, 9, 1, 5, 5, 5, 5, 1, 9, 1, 20, 11, 15, 1, 1},
        };
        drawObject(pane, objectMap);

        // Draw Circle
        int[][] circleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        //drawCircleObject(tankPane, circleMap);

        // Draw castle
        int[][] castleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        drawCastleObject(pane, castleMap);
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
                return "file:src\\Map_JAVA\\PNG2\\Background\\glassground2.png";
            case 2:
                return "file:src\\Map_JAVA\\PNG2\\Background\\glass ground .png";
            case 3:
                return "file:src\\Map_JAVA\\PNG2\\Object\\bigcircle.png";
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
                return "file:src\\Map_JAVA\\PNG2\\Object\\strawman.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG2\\Object\\straw2.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG2\\Object\\mushroom.png";
            case 5:
                return "file:src\\Map_JAVA\\PNG2\\Object\\flowers.png";
            case 6:
                return "file:src\\Map_JAVA\\PNG2\\Object\\barrel.png";
            case 7:
                return "file:src\\Map_JAVA\\PNG2\\Object\\smaltree2.png";
            case 8:
                return "file:src\\Map_JAVA\\PNG2\\Object\\smalltree4.png";
            case 9:
                return "file:src\\Map_JAVA\\PNG2\\Object\\bigmountain.png";
            case 10:
                return "file:src\\Map_JAVA\\PNG2\\Object\\smalltree3.png";
            case 11:
                return "file:src\\Map_JAVA\\PNG2\\Object\\smalltree1.png";
            case 12:
                return "file:src\\Map_JAVA\\PNG2\\Object\\smallhouse2.png";
            case 13:
                return "file:src\\Map_JAVA\\PNG2\\Object\\smallrock.png";
            case 14:
                return "file:src\\Map_JAVA\\PNG2\\Object\\smallhouse.png";
            case 15:
                return "file:src\\Map_JAVA\\PNG2\\Object\\spawnposition.png";
            case 16:
                return "file:src\\Map_JAVA\\PNG2\\Object\\well.png";
            case 17:
                return "file:src\\Map_JAVA\\PNG2\\Object\\rock2.png";
            case 18:
                return "file:src\\Map_JAVA\\PNG2\\Object\\longrock.png";
            case 19:
                return "file:src\\Map_JAVA\\PNG2\\Object\\grass1.png";
            case 20:
                return "file:src\\Map_JAVA\\PNG2\\Object\\grass2.png";
            case 21:
                return "file:src\\Map_JAVA\\PNG2\\Object\\rock3.png";
            case 22:
                return "file:src\\Map_JAVA\\PNG2\\Object\\rock4.png";
            case 23:
                return "file:src\\Map_JAVA\\PNG2\\Object\\barn.png";
            case 24:
                return "file:src\\Map_JAVA\\PNG2\\Object\\glass castle.png";
            case 25:
                return "file:src\\Map_JAVA\\PNG2\\Object\\windmill.png";
            case 26:
                return "file:src\\Map_JAVA\\PNG2\\Object\\grass.png";

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
                if (map[i][j] > 1){
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
                return "file:src\\Map_JAVA\\PNG2\\Object\\straw2.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG2\\Object\\windmill.png";
            case 5:
                return "file:src\\Map_JAVA\\PNG2\\Object\\barn.png";
            case 4:
                return "file:";
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
                if (map[i][j] > 1){
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
                return "file:src\\Map_JAVA\\PNG2\\Object\\bigcircle.png";
            default:
                return "file:";
        }
    }

    public void drawCircleObject(Pane pane, int[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                String imagePath = getCircleImagePath(map[i][j]);
                ImageView CircleTile = new ImageView();
                Rectangle rect = new Rectangle();
                CircleTile.setImage(new Image(imagePath));
                CircleTile.setScaleX(1.5);
                CircleTile.setScaleY(1.5);
                CircleTile.setFitHeight(300);
                CircleTile.setFitWidth(300);
                CircleTile.setTranslateX(70 * j - 70);
                CircleTile.setTranslateY(70 * i - 70);
                pane.getChildren().addAll(CircleTile);
                if(map[i][j] > 1){
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
}
