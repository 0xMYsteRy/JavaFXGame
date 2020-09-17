package Map_JAVA;

import Tank_JAVA.Tank;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Mapboss extends Application {
    // Constructor
    Scene scene;

    public Mapboss() {
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Loading an image");
        Pane tankPane;

        tankPane = new Pane();
        //Load the map
        Mapboss map4 = new Mapboss();
        map4.loadGround(tankPane);
        scene = new Scene(tankPane, 1400, 750);//1400x750
        //Create Player
        Tank b = new Tank(2, 3);
//        b.createPlayer(0, 0, tankPane, scene, RectList, objectList,map4);
//        Tank c = new Tank(2,4);
//        c.createPlayer(0,700,tankPane,scene,RectList,objectList);
//        Tank a = new Tank (3,1);
//        a.createPlayer(1330,0,tankPane,scene,RectList,objectList);
//        Tank d = new Tank (4,3);
//        d.createPlayer(1330,700,tankPane,scene,RectList,objectList);
        map4.loadObject(tankPane);
        //Adding scene to the stage
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

        // Draw castle
        int[][] castleMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1},
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

    public String getImagePath(int choice) {
        switch (choice) {
            case 1:
                return "file:src\\Map_JAVA\\PNG4\\Background\\grass2.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG4\\ground4.png";
            case 2:
                return "file:src\\Map_JAVA\\PNG4\\Background\\ground2.png";
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
                return "file:src\\Map_JAVA\\PNG4\\Object\\pine.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG4\\Object\\pine tree.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG4\\Object\\pine tree 1.png";
            case 5:
                return "file:src\\Map_JAVA\\PNG4\\Object\\decoration.png";
            case 6:
                return "file:src\\Map_JAVA\\PNG4\\Object\\direction.png";
            case 7:
                return "file:src\\Map_JAVA\\PNG4\\Object\\flower.png";
            case 8:
                return "file:src\\Map_JAVA\\PNG4\\Object\\flower3.png";
            case 9:
                return "file:src\\Map_JAVA\\PNG4\\Object\\flower3a.png";
            case 10:
                return "file:src\\Map_JAVA\\PNG4\\Object\\flower3b.png";
            case 11:
                return "file:src\\Map_JAVA\\PNG4\\Object\\flower4.png";
            case 12:
                return "file:src\\Map_JAVA\\PNG4\\Object\\flower5.png";
            case 13:
                return "file:src\\Map_JAVA\\PNG4\\Object\\grass.png";
            case 14:
                return "file:src\\Map_JAVA\\PNG4\\Object\\jar.png";
            case 15:
                return "file:src\\Map_JAVA\\PNG4\\Object\\pine.png";
            case 16:
                return "file:src\\Map_JAVA\\PNG4\\Object\\pine tree.png";
            case 17:
                return "file:src\\Map_JAVA\\PNG4\\Object\\pine tree 1.png";
            case 18:
                return "file:src\\Map_JAVA\\PNG4\\Object\\rock.png";
            case 19:
                return "file:src\\Map_JAVA\\PNG4\\Object\\rock3.png";
            case 20:
                return "file:src\\Map_JAVA\\PNG4\\Object\\small house.png";
            case 21:
                return "file:src\\Map_JAVA\\PNG4\\Object\\tomato.png";
            case 22:
                return "file:src\\Map_JAVA\\PNG4\\Object\\tree.png";
            case 23:
                return "file:src\\Map_JAVA\\PNG4\\Object\\tree2.png";
            case 24:
                return "file:src\\Map_JAVA\\PNG4\\Object\\tree7.png";
            case 25:
                return "file:src\\Map_JAVA\\PNG4\\Object\\tree8.png";
            case 26:
                return "file:src\\Map_JAVA\\PNG4\\Object\\treee.png";
            case 27:
                return "file:src\\Map_JAVA\\PNG4\\Object\\windmill.png";
            case 28:
                return  "file:src\\Map_JAVA\\PNG4\\Object\\wood.png";
            case 29:
                return "file:src\\Map_JAVA\\PNG4\\Object\\tree10.png";
            case 30:
                return "file:src\\Map_JAVA\\PNG4\\Object\\treasure.png";
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
                return "file:src\\Map_JAVA\\PNG4\\Object\\direction.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG4\\Object\\rock.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG4\\Object\\rock3.png";
            case 5:
                return "file:src\\Map_JAVA\\PNG4\\Object\\tree2.png";
            case 6:
                return "file:src\\Map_JAVA\\PNG4\\Object\\tree10.png";
            case 7:
                return "file:src\\Map_JAVA\\PNG4\\Object\\tree7.png";
            case 8:
                return "file:src\\Map_JAVA\\PNG4\\Object\\castle.png";
            case 9:
                return "file:src\\Map_JAVA\\PNG4\\Object\\direction2.png";
            case 10:
                return "file:src\\Map_JAVA\\PNG4\\Object\\direction3.png";
            case 11:
                return "file:src\\Map_JAVA\\PNG4\\Object\\direction4.png";
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

    //Draw Castle
    public String getCastleImagePath(int choice) {
        switch (choice) {
            case 1:
                //return nothing if the no need to add object on that tile.
                return "file:";
            case 2:
                return "file:src\\Map_JAVA\\PNG4\\Object\\windmill2.png";
            case 3:
                return "file:src\\Map_JAVA\\PNG4\\Object\\bird statue.png";
            case 4:
                return "file:src\\Map_JAVA\\PNG4\\Object\\castle 3.png";
            case 5:
                return "file:src\\Map_JAVA\\PNG4\\Object\\direction.png";
            case 6:
                return "file:src\\Map_JAVA\\PNG4\\Object\\castle.png";
            case 7:
                return "file:src\\Map_JAVA\\PNG4\\Object\\wood mine.png";
            case 8:
                return "file:src\\Map_JAVA\\PNG4\\Object\\gold mine.png";
            case 9:
                return "file:src\\Map_JAVA\\PNG4\\Object\\chimmey.png";
            case 10:
                return "file:src\\Map_JAVA\\PNG4\\Object\\fountain.png";
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


}
