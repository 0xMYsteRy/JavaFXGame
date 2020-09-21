package Scene_JAVA;

import Map_JAVA.MapPVP;
import Tank_JAVA.Tank;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Scene_MapPVP {
    private Stage stage;

    public Scene_MapPVP(){
    }
    Scene scene;

    public Scene setScene2(Stage stage) throws FileNotFoundException {
        stage.setTitle("Farm");
        Pane tankPane;
        MapPVP mapPVP = new MapPVP();
        tankPane = new Pane();
        Tank tank;
        mapPVP.loadGround(tankPane);
        mapPVP.loadObject(tankPane);
        scene = new Scene(tankPane, 1565, 770);
        tank = new Tank(1, 4);
        tank.createPlayer(0, 0, tankPane, scene,mapPVP.getRectList(),mapPVP.getobjectList() ,mapPVP.getObjBotList() ,null,null, 1);

        mapPVP.loadLayOut(tankPane, stage,tank);
        stage.setScene(scene);
        stage.show();
        return scene;
    }
}
