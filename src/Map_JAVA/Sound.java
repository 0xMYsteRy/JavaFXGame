package Map_JAVA;

import Tank_JAVA.Tank;
import javafx.animation.Animation;
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


public class Sound extends Application {
    Media media;
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

    public void music() {
        //String musicFile = "src/Map_JAVA/Sound/background.mp3";
        media = new Media(Paths.get("src/Map_JAVA/Sound/background.mp3").toUri().toString());
        //Media media = new Media(new File("src/Map_JAVA/Sound/background.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        // mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }


    public String getSound(int option) {
        switch (option) {
            case 1:
                return "src/Map_JAVA/Sound/background.mp3";
            case 2:
                return "src/Map_JAVA/Sound/background.mp3";
            case 3:
                return "src\\Map_JAVA\\Sound\\Guitar-Mayhem-2.mp3";
            case 4:
                return "src\\Map_JAVA\\Sound\\Guitar-Mayhem-5.mp3";
            case 5:
                return "src\\Map_JAVA\\Sound\\Insane-Gameplay.mp3";

            case 6:
                return "src\\Map_JAVA\\Sound\\Pirates.mp3";
            case 7:
                return "src/Map_JAVA/Sound/boss win.mp3";
            case 8:
                return "src/Map_JAVA/Sound/button click.wav";
            case 9:
                return "src/Map_JAVA/Sound/died.mp3";
            case 10:
                return "src/Map_JAVA/Sound/tankfire.wav";
            case 11:
                return "src/Map_JAVA/Sound/get shooted.wav";
            case 12:
                return "src/Map_JAVA/Sound/switch option.wav";
            case 13:
                return "src/Map_JAVA/Sound/explosion.mp3";
            case 14:
                return "src/Map_JAVA/Sound/victory.mp3";
            case 15:
                return "src/Map_JAVA/Sound/Explosion+9.mp3";
            default:
                return "";
        }
    }

    MediaPlayer player;

    public void loadSound(int option) {
        media = new Media(Paths.get(getSound(option)).toUri().toString());
        player = new MediaPlayer(media);
        if (option == 7) {
            player.setVolume(1);
            player.setStopTime(Duration.seconds(5));
            player.stop();
        }
        if (option == 5) {
            player.setVolume(0.5);
            player.setStartTime(Duration.seconds(2));
        }
        if (option == 10) {
            player.setVolume(0.8);
            player.setStopTime(Duration.seconds(2));
        }
        if (option == 14) {
            player.setVolume(1);
            player.setStartTime(Duration.seconds(2));
        } else {
            player.setStartTime(Duration.seconds(15));
            player.setVolume(0.2);
            player.setCycleCount(MediaPlayer.INDEFINITE);
        }
        player.play();

    }

    public void stopSound() {
        player.stop();
    }

    public void pauseSound() {
        player.pause();
    }


}


