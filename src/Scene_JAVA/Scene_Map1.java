package Scene_JAVA;

import Map_JAVA.Map;
import Tank_JAVA.Tank;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Scene_Map1 {
    private  Stage stage;

    public Scene_Map1(){
    }
    Scene scene;
    public Scene setScene1(Stage stage) throws FileNotFoundException {

        this.stage=stage;

        Pane tankPane = new Pane();

        DecimalFormat format = new DecimalFormat("00");

        //Load the map
        Tank c = new Tank(1, 4);
        Map map= new Map(c);
        map.loadGround(tankPane);
        javafx.scene.text.Font font2 = new javafx.scene.text.Font("Times New Roman",20);

        scene = new Scene(tankPane,1565,770);//1400x750
        //Create Player

        c.createPlayer(0, 0, tankPane, scene, map.getRectList(), map.getobjectList(),map.getObjBotList(),null,false,1);

        map.loadObject(tankPane);
        map.loadLayOut(tankPane,stage);
        return scene;

        //Adding scene to the stage
    }
}
