package Map_JAVA;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Map {
    Image backgroundImage1;
    Image backgroundImage2;
    Image objectPipe;
    Image objectPipeHeadLeft;
    Image objectPipeHeadRight;
    Image[] img;
    ImageView[] imageView;

    public Map() {
    }

    public void loadMap(Pane tankPane) {
        // Load image
        backgroundImage1 = new Image("file:src/Ultilities/PNG/Ground_Tile_01_C.png");
        backgroundImage2 = new Image("file:src/Ultilities/PNG/Ground_Tile_02_C.png");

        //Pipe
        objectPipe = new Image("file:src/Ultilities/PNG/Decor_Items/Decor_Pipe_B.png");
        objectPipeHeadLeft = new Image("file: src/Ultilities/PNG/Decor_Items/Decor_Pipe_A_02.png");
        objectPipeHeadRight = new Image("file:src/Ultilities/PNG/Decor_Items/Decor_Pipe_C_01.png");

        img = new Image[]{backgroundImage1, backgroundImage2};

        // Create map
        // 10 rows at the bottomn
        imageView = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView[i] = new ImageView();
            imageView[i].setImage(backgroundImage1);
            imageView[i].setFitHeight(70);
            imageView[i].setFitWidth(70);
            imageView[i].setTranslateX(70 * i);
            imageView[i].setTranslateY(700);
        }

        //10 row upwards
        ImageView[] imageView2 = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView2[i] = new ImageView();
            imageView2[i].setImage(backgroundImage1);
            imageView2[i].setFitHeight(70);
            imageView2[i].setFitWidth(70);
            imageView2[i].setTranslateX(70 * i);
            imageView2[i].setTranslateY(630);
        }

        // y = 560
        ImageView[] imageView3 = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView3[i] = new ImageView();
            imageView3[i].setImage(backgroundImage1);
            imageView3[i].setFitHeight(70);
            imageView3[i].setFitWidth(70);
            imageView3[i].setTranslateX(70 * i);
            imageView3[i].setTranslateY(560);
        }

        // y = 490
        ImageView[] imageView4 = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView4[i] = new ImageView();
            imageView4[i].setImage(backgroundImage1);
            imageView4[i].setFitHeight(70);
            imageView4[i].setFitWidth(70);
            imageView4[i].setTranslateX(70 * i);
            imageView4[i].setTranslateY(490);

        }

        // y = 420
        ImageView[] imageView5 = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView5[i] = new ImageView();
            imageView5[i].setImage(backgroundImage1);
            imageView5[i].setFitHeight(70);
            imageView5[i].setFitWidth(70);
            imageView5[i].setTranslateX(70 * i);
            imageView5[i].setTranslateY(420);
        }

        // y = 350
        ImageView[] imageView6 = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView6[i] = new ImageView();
            imageView6[i].setImage(backgroundImage1);
            imageView6[i].setFitHeight(70);
            imageView6[i].setFitWidth(70);
            imageView6[i].setTranslateX(70 * i);
            imageView6[i].setTranslateY(350);
        }

        // y = 280
        ImageView[] imageView7 = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView7[i] = new ImageView();
            imageView7[i].setImage(backgroundImage1);
            imageView7[i].setFitHeight(70);
            imageView7[i].setFitWidth(70);
            imageView7[i].setTranslateX(70 * i);
            imageView7[i].setTranslateY(280);
        }

        // y = 210
        ImageView[] imageView8 = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView8[i] = new ImageView();
            imageView8[i].setImage(backgroundImage1);
            imageView8[i].setFitHeight(70);
            imageView8[i].setFitWidth(70);
            imageView8[i].setTranslateX(70 * i);
            imageView8[i].setTranslateY(210);
        }

        // y = 140
        ImageView[] imageView9 = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView9[i] = new ImageView();
            imageView9[i].setImage(backgroundImage1);
            imageView9[i].setFitHeight(70);
            imageView9[i].setFitWidth(70);
            imageView9[i].setTranslateX(70 * i);
            imageView9[i].setTranslateY(140);
        }

        // y = 70
        ImageView[] imageView10 = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView10[i] = new ImageView();
            imageView10[i].setImage(backgroundImage1);
            imageView10[i].setFitHeight(70);
            imageView10[i].setFitWidth(70);
            imageView10[i].setTranslateX(70 * i);
            imageView10[i].setTranslateY(70);
        }

        // Top position
        ImageView[] imageView11 = new ImageView[20];
        for (int i = 0; i < 20; i++) {
            imageView11[i] = new ImageView();
            imageView11[i].setImage(backgroundImage1);
            imageView11[i].setFitHeight(70);
            imageView11[i].setFitWidth(70);
            imageView11[i].setTranslateX(70 * i);
            imageView11[i].setTranslateY(0);
        }

        //Add object to the scence
//        ImageView[] objectView2 = new ImageView[20];
//        for (int i = 0; i < 20; i++) {
//
//            imageView2[i] = new ImageView();
//            if (i == 0) {
//                objectView2[i].setImage(objectPipe);
//                objectView2[i].setFitHeight(70);
//                objectView2[i].setFitWidth(70);
//                objectView2[i].setTranslateX(70 * i);
//                objectView2[i].setTranslateY(490);
//            } else if (i == 1) {
//                objectView2[i].setImage(objectPipe);
//                objectView2[i].setFitHeight(70);
//                objectView2[i].setFitWidth(70);
//                objectView2[i].setTranslateX(70 * i);
//                objectView2[i].setTranslateY(490);
//            } else {
//                objectView2[i].setImage(objectPipe);
//                objectView2[i].setFitHeight(70);
//                objectView2[i].setFitWidth(70);
//                objectView2[i].setTranslateX(70 * i);
//                objectView2[i].setTranslateY(490);
//            }
//        }

        // Add all background components to the map
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

        // Add objects to the map
        //tankPane.getChildren().addAll(objectView2);
    }
}
