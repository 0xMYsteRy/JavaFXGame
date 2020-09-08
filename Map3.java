package Map_JAVA;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;






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
                {8, 9, 10, 10, 10, 10, 11, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,8, 8, 8},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        };
        drawMap(tankPane, pvpMap);

        //  Draw object
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
        //drawObject(tankPane, objectMap);

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
       // drawCastleObject(tankPane, castleMap);
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
                return "file:src\\Map_JAVA\\PNG3\\beach.png";
            case 2:
                return "file:src\\Map_JAVA\\PNG3\\beach2.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG3\\beach3.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG3\\grass.png";
            case 5:
                return "file:src\\Map_JAVA\\PNG3\\beacha.png";
            case 6:
                return "file:src\\Map_JAVA\\PNG3\\beachb.png";
            case 7:
                return "file:src\\Map_JAVA\\PNG3\\beachc.png";
            case 8:
                return "file:src\\Map_JAVA\\PNG3\\sea.png";
            case 9:
                return "file:src\\Map_JAVA\\PNG3\\seax.png";
            case 10:
                return "file:src\\Map_JAVA\\PNG3\\seay.png";
            case 11:
                return "file:src\\Map_JAVA\\PNG3\\seaz.png";

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
                return "file:src\\Ultilities\\PNG\\strawman.png";
            case 3:
                return "file:src\\Ultilities\\PNG\\straw2.png";
            case 4:
                return "file:src\\Ultilities\\PNG\\mushroom.png";
            case 5:
                return "file:src\\Ultilities\\PNG\\flowers.png";
            case 6:
                return "file:src\\Ultilities\\PNG\\barrel.png";
            case 7:
                return "file:src\\Ultilities\\PNG\\smaltree2.png";
            case 8:
                return "file:src\\Ultilities\\PNG\\smalltree4.png";
            case 9:
                return "file:src\\Ultilities\\PNG\\bigmountain.png";
            case 10:
                return "file:src\\Ultilities\\PNG\\smalltree3.png";
            case 11:
                return "file:src\\Ultilities\\PNG\\smalltree1.png";
            case 12:
                return "file:src\\Ultilities\\PNG\\smallhouse2.png";
            case 13:
                return "file:src\\Ultilities\\PNG\\smallrock.png";
            case 14:
                return "file:src\\Ultilities\\PNG\\smallhouse.png";
            case 15:
                return "file:src\\Ultilities\\PNG\\spawnposition.png";
            case 16:
                return "file:src\\Ultilities\\PNG\\well.png";
            case 17:
                return "file:src\\Ultilities\\PNG\\rock2.png";
            case 18:
                return "file:src\\Ultilities\\PNG\\longrock.png";
            case 19:
                return "file:src\\Ultilities\\PNG\\grass1.png";
            case 20:
                return "file:src\\Ultilities\\PNG\\grass2.png";
            case 21:
                return "file:src\\Ultilities\\PNG\\rock3.png";
            case 22:
                return "file:src\\Ultilities\\PNG\\rock4.png";
            case 23:
                return "file:src\\Ultilities\\PNG\\barn.png";
            case 24:
                return "file:src\\Ultilities\\PNG\\glass castle.png";
            case 25:
                return "file:src\\Ultilities\\PNG\\windmill.png";
            case 26:
                return "file:src\\Ultilities\\PNG\\grass.png";

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
                return "file:src\\Ultilities\\PNG\\straw2.png";
            case 3:
                return "file:src\\Ultilities\\PNG\\windmill.png";
            case 5:
                return "file:src\\Ultilities\\PNG\\barn.png";
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
                return "file:src/Ultilities/PNG/bigcircle.png";
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
                CircleTile.setScaleX(1.5);
                CircleTile.setScaleY(1.5);
                CircleTile.setFitHeight(300);
                CircleTile.setFitWidth(300);
                CircleTile.setTranslateX(70 * j - 70);
                CircleTile.setTranslateY(70 * i - 70);
                pane.getChildren().addAll(CircleTile);
            }
        }
    }
}

