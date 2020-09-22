package Map_JAVA;

import Tank_JAVA.Tank;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.Paths;


public class Sound {
    MediaPlayer mediaPlayer;

    public void music() {
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
                //Shoot
                return "src/Map_JAVA/Sound/strong_exploision.mp3";
            //Load background music
            case 2:
                return "src/Map_JAVA/Sound/background.mp3";
            //Tank Selection
            case 3:
                return "src/Map_JAVA/Sound/TankSelect.mp3";
            default:
                return "";
        }
    }

    //Huy
    MediaPlayer player;

    public void loadSound(int option) {
        Media sound = new Media(Paths.get(getSound(option)).toUri().toString());

        player = new MediaPlayer(sound);
        player.setVolume(1);
        player.setCycleCount(MediaPlayer.INDEFINITE);

        //Fire bullet
        if (option == 1) {
            player.setCycleCount(1);
        }
        player.play();
    }
    public void stopSound(){
        player.stop();
    }
}


