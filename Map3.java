package Map_JAVA;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Arrays;


public class   Map3 extends Application {
    // Constructor
    public Map3() {
    }

    @Override
    public void start(Stage stage) throws Exception {
    }

    public void loadMap(Pane tankPane) {

        //Draw background
        int[][] pvpMap = {
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3},
                {1, 3, 3, 1, 4, 1, 1, 2, 1, 3, 1, 3, 3, 2, 3, 2, 1, 2, 3, 1},
                {2, 2, 2, 2, 1, 1, 1, 1,2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2},
                {1, 4, 1, 2, 3, 3, 1, 4, 4, 2, 2, 1, 1, 1, 1, 4, 1, 4,2, 2},
                {2, 2, 1, 1,2, 1, 2, 1, 1, 5, 6, 6, 6, 6, 7, 1, 1, 1, 2, 2},
                {2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2},
                {9, 1, 1, 1, 1, 1, 1, 11, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,8, 8, 8},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        };
        drawMap(tankPane, pvpMap);

        //  Draw object
        int[][] objectMap = {
                {1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 18, 1, 1, 1, 1, 1, 1, 1, 25, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 20, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 26, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 22, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 20, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 26, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 9, 1, 1, 1, 22, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 4, 1, 1},
                {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 23},
        };
        drawObject(tankPane, objectMap);

        // Draw Circle
        int[][] objectMap2 = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        drawObject2(tankPane, objectMap2);

        // Draw castle
        int[][] castleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1},
                {1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1},
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
                return "file:src\\Map_JAVA\\PNG3\\Background\\beach.png";
            case 2:
                return "file:src\\Map_JAVA\\PNG3\\Background\\beach2.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG3\\Background\\beach3.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG3\\Background\\grass.png";
            case 5:
                return "file:src\\Map_JAVA\\PNG3\\Background\\beacha.png";
            case 6:
                return "file:src\\Map_JAVA\\PNG3\\Background\\beachb.png";
            case 7:
                return "file:src\\Map_JAVA\\PNG3\\Background\\beachc.png";
            case 8:
                return "file:src\\Map_JAVA\\PNG3\\Background\\sea.png";
            case 9:
                return "file:src\\Map_JAVA\\PNG3\\Background\\seax.png";
            case 10:
                return "file:src\\Map_JAVA\\PNG3\\Background\\seay.png";
            case 11:
                return "file:src\\Map_JAVA\\PNG3\\Background\\seaz.png";

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
                return "file:src\\Map_JAVA\\PNG3\\Object\\ball.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG3\\Object\\ball1.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG3\\Object\\ball2.png";
            case 5:
                return "file:src\\Map_JAVA\\PNG3\\Object\\ball3.png";
            case 6:
                return "file:src\\Map_JAVA\\PNG3\\Object\\big starfish.png";
            case 7:
                return "file:src\\Map_JAVA\\PNG3\\Object\\boat.png";
            case 8:
                return "file:src\\Map_JAVA\\PNG3\\Object\\boat2.png";
            case 9:
                return "file:src\\Map_JAVA\\PNG3\\Object\\boat3.png";
            case 10:
                return "file:src\\Map_JAVA\\PNG3\\Object\\boat4.png";
            case 11:
                return "file:src\\Map_JAVA\\PNG3\\Object\\boat5.png";
            case 12:
                return "file:src\\Map_JAVA\\PNG3\\Object\\castle.png";
            case 13:
                return "file:src\\Map_JAVA\\PNG3\\Object\\coconut tree 1.png";
            case 14:
                return "file:src\\Map_JAVA\\PNG3\\Object\\coconut tree 2.png";
            case 15:
                return "file:src\\Map_JAVA\\PNG3\\Object\\coconut tree 3.png";
            case 16:
                return "file:src\\Map_JAVA\\PNG3\\Object\\coconut tree 4.png";
            case 17:
                return "file:src\\Map_JAVA\\PNG3\\Object\\hat.png";
            case 18:
                return "file:src\\Map_JAVA\\PNG3\\Object\\hot air ballon.png";
            case 19:
                return "file:src\\Map_JAVA\\PNG3\\Object\\sand.png";
            case 20:
                return "file:src\\Map_JAVA\\PNG3\\Object\\shell.png";
            case 21:
                return "file:src\\Map_JAVA\\PNG3\\Object\\showel.png";
            case 22:
                return "file:src\\Map_JAVA\\PNG3\\Object\\star fish 2.png";
            case 23:
                return "file:src\\Map_JAVA\\PNG3\\Object\\tube.png";
            case 24:
                return "file:src\\Map_JAVA\\PNG3\\Object\\umbrella.png";
            case 25:
                return "file:src\\Map_JAVA\\PNG3\\Object\\umbrella2.png";
            case 26:
                return "file:src\\Map_JAVA\\PNG3\\Object\\sandal.png";
            case 27:
                return "file:src\\Map_JAVA\\PNG3\\Object\\whale.png";
            case 28:
                return "file:src\\Map_JAVA\\PNG3\\Object\\sunglasses.png";
            case 29:
                return "file:src\\Map_JAVA\\PNG3\\Object\\coconut tree 5.png";

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
                return "file:src\\Map_JAVA\\PNG3\\Object\\boat4.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG3\\Object\\coconut tree 3.png";
            case 5:
                return "file:src\\Map_JAVA\\PNG3\\Object\\coconut tree 2.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG3\\Object\\coconut tree 5.png";
            case 6:
                return "file:src\\Map_JAVA\\PNG3\\Object\\umbrella combo.png";
            case 7:
                return "file:src\\Map_JAVA\\PNG3\\Object\\boat2.png";
            case 8:
                return "file:src\\Map_JAVA\\PNG3\\Object\\big chair.png";
            case 9:
                return "file:src\\Map_JAVA\\PNG3\\Object\\castle.png";
            case 10:
                return "file:src\\Map_JAVA\\PNG3\\Object\\sand.png";
            case 11:
                return "file:src\\Map_JAVA\\PNG3\\Object\\showel.png";
            default:
                return "";
        }
    }


    public void drawCastleObject(Pane pane, int[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                String imagePath = getCastleImagePath(map[i][j]);
                ImageView CastleTile = new ImageView();
                CastleTile.setImage(new Image(imagePath));
                CastleTile.setScaleX(1.5);
                CastleTile.setScaleY(1.5);
                CastleTile.setFitHeight(150);
                CastleTile.setFitWidth(150);
                CastleTile.setTranslateX(70 * j - 70);
                CastleTile.setTranslateY(70 * i - 70);
                pane.getChildren().addAll(CastleTile);
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
                return "file:src\\Map_JAVA\\PNG3\\Object\\showel.png";
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
                CircleTile.setScaleX(1);
                CircleTile.setScaleY(1);
                CircleTile.setFitHeight(140);
                CircleTile.setFitWidth(140);
                CircleTile.setTranslateX(70 * j - 70);
                CircleTile.setTranslateY(70 * i - 70);
                pane.getChildren().addAll(CircleTile);
            }
        }
    }
}

