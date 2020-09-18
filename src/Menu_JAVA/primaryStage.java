package Menu_JAVA;

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
        stage.setScene(new Scene(mainMenu.createContent()));
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }
}
