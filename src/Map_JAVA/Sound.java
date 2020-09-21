package Map_JAVA;

import Tank_JAVA.Tank;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;


public class Sound extends Application {

   MediaPlayer mediaPlayer;


    public void start(Stage stage) throws Exception {
        Scene scene;
        MediaPlayer mediaPlayer;
        stage.setTitle("SNOWY DOWNY");
        Pane pane = new Pane();
        scene = new Scene(pane, 1565, 770);//1400x750
        //music();
        loadSound(2);
        stage.setScene(scene);
        stage.show();
    }

    public void music(){
        //String musicFile = "src/Map_JAVA/Sound/background.mp3";
        Media media = new Media(Paths.get("src/Map_JAVA/Sound/background.mp3").toUri().toString());
        //Media media = new Media(new File("src/Map_JAVA/Sound/background.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        // mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }



    public String getSound(int option) {
        switch (option) {
            case 1:
                return new File("src/Map_JAVA/Sound/a.mp3").toURI().toString();
            case 2:
                return "src/Map_JAVA/Sound/background.mp3";
            case 3:
                return new File("src/Map_JAVA/Sound/a.mp3").toURI().toString();
            default:
                return "";
        }
    }
    MediaPlayer player;
    public void loadSound(int option){
        Media sound = new Media(Paths.get(getSound(option)).toUri().toString());
        System.out.println(sound);
        player = new MediaPlayer(sound);
        player.setVolume(1);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
    }
}


