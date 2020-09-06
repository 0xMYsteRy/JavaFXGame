package Map_JAVA;

import Tank_JAVA.Tank;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Map extends Application {
    Image backgroundImage1;
    Image backgroundImage2;
    Image objectPipe;
    Image objectPipeHeadLeft;
    Image objectPipeHeadRight;
    Image[] img;
    ImageView[] imageView;

    // Constructor
    public Map() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        //tankPane = new Pane();
    }

    public void loadMap(Pane tankPane) {
        backgroundImage1 = new Image("file:src/Ultilities/PNG/Ground_Tile_01_C.png");
        // Load image
        backgroundImage2 = new Image("file:src/Ultilities/PNG/Ground_Tile_02_C.png");

        //Pipe
        objectPipe = new Image("file:src/Ultilities/PNG/Decor_Items/Decor_Pipe_B.png");
        objectPipeHeadLeft = new Image("file: src/Ultilities/PNG/Decor_Items/Decor_Pipe_A_02.png");
        objectPipeHeadRight = new Image("file:src/Ultilities/PNG/Decor_Items/Decor_Pipe_C_01.png");

        //Item
        Image objectTree = new Image("file:src/GuttyKreumNatureTilesvol1/tree96x96transparent.png");

        img = new Image[]{backgroundImage1, backgroundImage2};

        int[][] pvpMap = {
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
        };
        int[][] objectMap = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };


//        ImageView[] imageView11 = new ImageView[20];
//        for (int i = 0; i < 20; i++) {
//            imageView11[i] = new ImageView();
//            imageView11[i].setImage(objectTree);
//            if (i == 0) {
////                imageView11[i].setScaleX(0);
////                imageView11[i].setScaleY(0);
//                imageView11[i].setFitHeight(70);
//                imageView11[i].setFitWidth(70);
//                imageView11[i].setTranslateX(70 * i);
//                imageView11[i].setTranslateY(540);
//            }
//        }

        drawMap(tankPane, pvpMap);
        drawObject(tankPane, objectMap);
        //tankPane.getChildren().addAll(imageView11);

    }

    public void drawObject(Pane pane, int[][] objectMap) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                // System.out.println(i+" "+j);
                String imagePath = callImageObject(objectMap[i][j]);
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

    public String callImageObject(int choice) {
        switch (choice) {
            case 1:
                return "file:src/Ultilities/PNG/Ground_Tile_01_C.png";
            case 2:
                return "file:src/GuttyKreumNatureTilesvol1/tree96x96transparent.png";
            case 3:
                return "file:src/Ultilities/PNG/Ground_Tile_02_C.png";
            default:
                System.out.println("Wrong image Choice!");
                return "Wrong choice";
        }
    }

    public void drawMap(Pane pane, int[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 20; j++) {
                // System.out.println(i+" "+j);
                String imagePath = callImage(map[i][j]);
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

    public String callImage(int choice) {
        switch (choice) {
            case 1:
                return "file:src/Ultilities/PNG/Ground_Tile_01_C.png";
            case 2:
                return "file:src/Ultilities/PNG/Ground_Tile_02_C.png";
            case 3:
                return "file:src/Ultilities/PNG/Ground_Tile_02_C.png";
            default:
                System.out.println("Wrong image Choice!");
                return "Wrong choice";
        }
    }


}
