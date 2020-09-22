package Menu_JAVA;

import Map_JAVA.Sound;
import Scene_JAVA.Scene_Map1;
import Scene_JAVA.Scene_Map2;
import Scene_JAVA.Scene_MapBoss;
import Scene_JAVA.Scene_MapPVP;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class primaryStage extends Application {
    static Stage stage ;
    MainMenu mainMenu = new MainMenu();

    public primaryStage() throws FileNotFoundException {
    }

    @Override
    public void start(Stage stage1) throws Exception {
        stage=stage1;

        stage.titleProperty().bind(I18N.createStringBinding("window.title"));
        stage.setScene(new Scene(mainMenu.createContent()));

        stage.show();
    }
    public static void setScene(int choice) throws FileNotFoundException {
        switch (choice){
            case 1: //map1 bot
                Scene_Map1 scene_map1= new Scene_Map1();
                stage.setScene(scene_map1.setScene1(stage));
                break;
            case 2:
                Scene_Map2 scene_map2 = new Scene_Map2();
                stage.setScene(scene_map2.setScene2(stage));
                break;
            case 3:
                Scene_MapBoss scene_mapBoss = new Scene_MapBoss();
                stage.setScene(scene_mapBoss.setSceneBoss(stage,1,2));
            case 4:
                Scene_MapPVP scene_mapPVP = new Scene_MapPVP();
                stage.setScene(scene_mapPVP.setScenePVP(stage));
            case 5:
                MainMenu mainMenu1 = new MainMenu();
                stage.setScene(new Scene(mainMenu1.createContent()));
        }
    }
    public static Stage getStage() {
        return stage;
    }
}
