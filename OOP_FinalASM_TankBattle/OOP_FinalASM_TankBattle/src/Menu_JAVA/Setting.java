package Menu_JAVA;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Setting extends Application {
    Pane root = new Pane();
    MainMenu mainMenu;

    public Setting() throws FileNotFoundException {

   }
    public Parent createSettingContent() throws FileNotFoundException {
        mainMenu= new MainMenu();

        root.setPrefSize(400, 300);

        Text settingTitle = new Text("SETTING");
        settingTitle.setTranslateX(1500);
        settingTitle.setTranslateY(50);
        settingTitle.setFill(Color.GREY);
        settingTitle.setStroke(Color.WHITE);
        settingTitle.setOnMouseClicked(e->{
            settingTitle.setFill(Color.BLACK);
        });
        settingTitle.setFont(Font.loadFont(MainMenu.class.getResource("res/Penumbra-HalfSerif-Std_35114.ttf").toExternalForm(), 30));

        Text language = new Text("Language");
        language.setFont(Font.loadFont(MainMenu.class.getResource("res/Penumbra-HalfSerif-Std_35114.ttf").toExternalForm(), 20));
        Button eng = new Button("English");
        eng.setMinWidth(100);
        eng.setMinHeight(20);
        eng.setOnMouseClicked(e -> {
        });
        Button vn = new Button("Tiếng Việt");
        vn.setMinWidth(100);
        vn.setMinHeight(20);
        vn.setOnMouseClicked(e -> {
        });
        HBox languageBox = new HBox(20, language, eng, vn);
        languageBox.setTranslateX(20);
        languageBox.setTranslateY(120);

        Button control = new Button("Control");
        control.setMinWidth(100);
        control.setMinHeight(20);
        Button faq = new Button("FAQ");
        faq.setMinHeight(20);
        faq.setMinWidth(100);
        HBox hbox1 = new HBox(20, control, faq);
        hbox1.setTranslateX(20);
        hbox1.setTranslateY(170);

        Button credit = new Button("Credits");
        credit.setMinWidth(100);
        credit.setMinHeight(20);
        Button contact = new Button("Contact us");
        contact.setMinWidth(100);
        contact.setMinHeight(20);
        HBox hbox2 = new HBox(20, credit, contact);
        hbox2.setTranslateX(20);
        hbox2.setTranslateY(220);

        Button closeButton = new Button("Close");
        closeButton.setMinWidth(400);
        closeButton.setMinHeight(30);
        closeButton.setAlignment(Pos.BOTTOM_CENTER);
        closeButton.setTranslateY(270);
        closeButton.setOnMouseClicked(mouseEvent -> {
            try {
                handleCloseButtonAction(mouseEvent);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Wrong at setting call menu");
            }
        });

        root.getChildren().addAll(settingTitle, languageBox, hbox1, hbox2, closeButton);
        return root;
    }

    public void handleCloseButtonAction(MouseEvent event) throws FileNotFoundException {
        primaryStage.getStage().setScene(new Scene(mainMenu.createContent()));
//        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }



    @Override
    public void start(Stage settingStage) throws Exception {
        Scene scene = new Scene(createSettingContent());
        settingStage.setTitle("Setting");
//        settingStage.setScene(scene);
        settingStage.show();
    }
}

