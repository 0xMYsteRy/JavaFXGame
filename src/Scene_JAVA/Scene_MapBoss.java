package Scene_JAVA;


import Map_JAVA.Mapboss;
import Tank_JAVA.Tank;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Scene_MapBoss {
    private Stage stage;
    public Scene_MapBoss(){
    }
    Scene scene;

    public Scene setSceneBoss (Stage stage,int choice,int color) throws FileNotFoundException {
        stage.setTitle("SNOWY DOWNY");
        Tank c;
        Pane tankPane = new Pane();
        Mapboss mapboss = new Mapboss(choice,color);
        mapboss.loadGround(tankPane);
        scene = new Scene(tankPane,1565,770);//1400x750
        c = new Tank(1, 4);
        c.createPlayer(0, 0, tankPane, scene,mapboss.getRectList() , mapboss.getobjectList(),mapboss.getObjBotList(),null,null,1);
        mapboss.loadObject(tankPane);
        mapboss.loadLayOut(tankPane,stage);
        stage.setScene(scene);
        stage.show();
        return scene;
    }
}
