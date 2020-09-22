package Menu_JAVA;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Locale;

public class Setting{
    CreditPopup creditPopup = new CreditPopup();
    Guide guide = new Guide();
    Pane root = new Pane();
    MainMenu mainMenu;
    Scene creditScene = new Scene(creditPopup.popupContent());
    Scene guideScene = new Scene(guide.guideWindow());
    private Integer numSwitches = 0;

    public Setting() throws FileNotFoundException {

    }
    public Parent createSettingContent() throws FileNotFoundException {
        mainMenu= new MainMenu();

        root.setPrefSize(1280, 720);

        String imagePath = "file:src/Menu_JAVA/res/background.png";
        ImageView background = new ImageView(new Image(imagePath));

        Text settingTitle = new Text("SETTING");
        settingTitle.setTranslateX(450);
        settingTitle.setTranslateY(100);
        settingTitle.setFill(Color.GREY);
        settingTitle.setStroke(Color.WHITE);
        settingTitle.setOnMouseClicked(e->{
            settingTitle.setFill(Color.BLACK);
        });
        settingTitle.setFont(Font.loadFont(MainMenu.class.getResource("res/Penumbra-HalfSerif-Std_35114.ttf").toExternalForm(), 100));

        Text language = new Text("Language");
        language.setFill(Color.WHITE);
        language.setFont(Font.loadFont(MainMenu.class.getResource("res/Penumbra-HalfSerif-Std_35114.ttf").toExternalForm(), 40));

        Button eng = new Button("English");
        eng.setTooltip(I18N.tooltipForKey("button.english.tooltip"));
        eng.setOnAction((evt) -> switchLanguage(Locale.ENGLISH));
        eng.setMinWidth(200);
        eng.setMinHeight(40);

        Button vn = new Button("Tiếng Việt");
        vn.setTooltip(I18N.tooltipForKey("button.vietnam.tooltip"));
        vn.setOnAction((evt) -> switchLanguage((new Locale("vi", "VN"))));
        vn.setMinWidth(200);
        vn.setMinHeight(40);
        HBox languageBox = new HBox(40, language, eng, vn);

        languageBox.setTranslateX(400);
        languageBox.setTranslateY(200);

        Button control = new Button("How to play");
        control.setMinWidth(200);
        control.setMinHeight(40);
        control.setOnMouseClicked(e -> {
            Stage guideStage = new Stage();
            guideStage.setTitle("How to play");
            guideStage.setScene(guideScene);
            guideStage.setX(300);
            guideStage.setY(250);
            guideStage.show();
        });
        Button faq = new Button("FAQ");
        faq.setMinHeight(40);
        faq.setMinWidth(200);
        HBox hbox1 = new HBox(40, control, faq);
        hbox1.setTranslateX(400);
        hbox1.setTranslateY(280);

        Button credit = new Button("Credits");
        credit.setMinWidth(200);
        credit.setMinHeight(40);
        credit.setOnMouseClicked(e -> {
            Stage creditStage = new Stage();
            creditStage.setScene(creditScene);
            creditStage.setX(300);
            creditStage.setY(300);
            creditStage.setTitle("Credits");
            creditStage.show();
        });
        Button contact = new Button("Contact us");
        contact.setMinWidth(200);
        contact.setMinHeight(40);
        HBox hbox2 = new HBox(20, credit, contact);
        hbox2.setTranslateX(400);
        hbox2.setTranslateY(360);

        Button closeButton = new Button("Close");
        closeButton.setMinWidth(600);
        closeButton.setMinHeight(40);
        closeButton.setAlignment(Pos.BOTTOM_CENTER);
        closeButton.setTranslateX(400);
        closeButton.setTranslateY(500);
        closeButton.setOnMouseClicked(mouseEvent -> {
            try {
                handleCloseButtonAction(mouseEvent);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        root.getChildren().addAll(background, settingTitle, languageBox, hbox1, hbox2, closeButton);
        return root;
    }

    public void handleCloseButtonAction(MouseEvent event) throws FileNotFoundException {
        primaryStage.getStage().setScene(new Scene(mainMenu.createContent()));
    }
    private void switchLanguage(Locale locale) {
        numSwitches++;
        I18N.setLocale(locale);
    }
}
