package Menu_JAVA;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.property.StringPropertyBase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Locale;

public class Setting {
    Pane root = new Pane();
    MainMenu mainMenu;
    private Integer numSwitches = 0;

    public Setting() throws FileNotFoundException {

   }
    public Parent createSettingContent() throws FileNotFoundException {
        BorderPane content = new BorderPane();
        mainMenu= new MainMenu();

        //Load background
        String imagePath = "file:src/Menu_JAVA/res/background.png";
        ImageView background = new ImageView(new Image(imagePath));

        root.setPrefSize(1280, 720);

        Text settingTitle = new Text("SETTING");
        settingTitle.setTranslateX(1500);
        settingTitle.setTranslateY(50);
        settingTitle.setFill(Color.GREY);
        settingTitle.setStroke(Color.WHITE);
        settingTitle.setOnMouseClicked(e->{
            settingTitle.setFill(Color.BLACK);
        });
        settingTitle.setFont(Font.loadFont(MainMenu.class.getResource("res/Penumbra-HalfSerif-Std_35114.ttf").toExternalForm(), 30));

        Text language = new Text("Menu_JAVA/Language");
        language.setFont(Font.loadFont(MainMenu.class.getResource("res/Penumbra-HalfSerif-Std_35114.ttf").toExternalForm(), 20));

        Button buttonEnglish = I18N.buttonForKey("button.english");
        buttonEnglish.setTooltip(I18N.tooltipForKey("button.english.tooltip"));
        buttonEnglish.setOnAction((evt) -> switchLanguage(Locale.ENGLISH));
        buttonEnglish.setMinWidth(100);
        buttonEnglish.setMinHeight(20);


        Button buttonVietNam = I18N.buttonForKey("button.vietnam");
        buttonVietNam.setTooltip(I18N.tooltipForKey("button.vietnam.tooltip"));
        buttonVietNam.setOnAction((evt) -> switchLanguage((new Locale("vi", "VN"))));
        buttonVietNam.setMinWidth(100);
        buttonVietNam.setMinHeight(20);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5, 5, 5, 5));
        hbox.setSpacing(5);
        hbox.getChildren().add(buttonVietNam);
        hbox.getChildren().add(buttonEnglish);
        hbox.setTranslateX(20);
        hbox.setTranslateY(120);

        Button control = new Button("Control");
        buttonVietNam.setTooltip(I18N.tooltipForKey("button.vietnam.control"));
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
                handleCloseButtonAction();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Wrong at setting call menu");
            }
        });

        content.setTop(hbox);
        final Label label = I18N.labelForValue(() -> I18N.get("label.numSwitches", numSwitches));
        content.setBottom(label);

        root.getChildren().add(background);
        //root.getChildren().addAll(settingTitle, hbox);
        root.getChildren().addAll(settingTitle, hbox, hbox1, hbox2, closeButton);
        return root;
    }
    private void switchLanguage(Locale locale) {
        numSwitches++;
        I18N.setLocale(locale);
    }

    public void handleCloseButtonAction() throws FileNotFoundException {
        primaryStage.getStage().setScene(new Scene(mainMenu.createContent()));
//        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}


