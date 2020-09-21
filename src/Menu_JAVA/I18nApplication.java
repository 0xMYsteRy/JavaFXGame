package Menu_JAVA;

import Menu_JAVA.I18N;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Locale;

public class I18nApplication extends Application {
    private Integer numSwitches = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.titleProperty().bind(I18N.createStringBinding("window.title"));
        Locale locale = new Locale("vi", "VN");

        // create content
        BorderPane content = new BorderPane();

        // at the top two buttons
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5, 5, 5, 5));
        hbox.setSpacing(5);

        Button buttonVietNam = I18N.buttonForKey("button.vietnam");
        buttonVietNam.setTooltip(I18N.tooltipForKey("button.vietnam.tooltip"));
        buttonVietNam.setOnAction((evt) -> switchLanguage((new Locale("vi", "VN"))));
        hbox.getChildren().add(buttonVietNam);

        Button buttonEnglish = I18N.buttonForKey("button.english");
        buttonEnglish.setTooltip(I18N.tooltipForKey("button.english.tooltip"));
        buttonEnglish.setOnAction((evt) -> switchLanguage(Locale.ENGLISH));
        hbox.getChildren().add(buttonEnglish);

        content.setTop(hbox);

        // a label to display the number of changes, recalculating the text on every change
        final Label label = I18N.labelForValue(() -> I18N.get("label.numSwitches", numSwitches));
        content.setBottom(label);

        primaryStage.setScene(new Scene(content, 400, 200));
        primaryStage.show();
    }

    private void switchLanguage(Locale locale) {
        numSwitches++;
        I18N.setLocale(locale);
    }
}