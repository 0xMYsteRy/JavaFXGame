package Scene_JAVA;

import Map_JAVA.Map2;
import Map_JAVA.MapPVP;
import Tank_JAVA.Tank;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Scene_Map2 {
    private Stage stage;

    public Scene_Map2(){
    }
    Scene scene;

    public Scene setScene2(Stage stage) throws FileNotFoundException {
        stage.setTitle("Son of the BEACH");
        Pane tankPane;
        Map2 map2 = new Map2();
        tankPane = new Pane();
        Tank tank;
        map2.loadGround(tankPane,stage);
        map2.loadObject(tankPane);
        scene = new Scene(tankPane, 1565, 770);
        tank = new Tank(1, 4);
        tank.createPlayer(0, 0, tankPane, scene,map2.getRectList(),map2.getobjectList() ,map2.getObjBotList() ,null,null, 1);
        stage.setScene(scene);
        stage.show();
        return scene;
    }
}
