package Menu_JAVA;

import java.io.FileNotFoundException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Tank_JAVA.Tank;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class mainMenu extends Application {

    private static final Font FONT = Font.font("", FontWeight.BOLD, 40);
    private static final Font FONT2 = Font.font("", FontWeight.BOLD, 100);

    private VBox menuBox;
    private int currentItem = 0;

    private ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();

    private Parent createContent() throws FileNotFoundException {
        Pane root = new Pane();
        root.setPrefSize(1280, 720);

        String imagePath = "file:src/Menu_JAVA/background.png";
        ImageView background = new ImageView(new Image(imagePath));

        ContentFrame frame1 = new ContentFrame(createTankContent(20,1,1));
        ContentFrame frame2 = new ContentFrame(createTankContent(20,2,2));
        ContentFrame frame3 = new ContentFrame(createTankContent(20,3,3));
        ContentFrame frame4 = new ContentFrame(createTankContent(20,4,4));

        HBox hbox = new HBox(20, frame1, frame2, frame3, frame4);
        hbox.setTranslateX(20);
        hbox.setTranslateY(50);

        // Tank User choice
        ContentFrame frame5 = new ContentFrame(createTankContent(20,1, 1));
        frame5.setTranslateX(30);
        frame5.setTranslateY(450);

        MenuItem itemExit = new MenuItem("EXIT");
        itemExit.setOnActivate(() -> System.exit(0));

        menuBox = new VBox(15,
                new MenuItem("Start"),
                new MenuItem("Campaign"),
                new MenuItem("Multiplayer"),
                new MenuItem("Setting"),
                itemExit);
        menuBox.setAlignment(Pos.BOTTOM_CENTER);
        menuBox.setTranslateX(950);
        menuBox.setTranslateY(330);

        Text name = new Text("  TANK \nBATTLE");
        name.setTranslateX(900);
        name.setTranslateY(120);
        name.setFill(Color.BLUE);
        name.setFont(FONT2);

        getMenuItem(0).setActive(true);

        root.getChildren().addAll(background, hbox, menuBox, name, frame5);
        return root;
    }

    private Node createTankContent(int x,int choice, int color) throws FileNotFoundException {
        Tank tank = new Tank(choice,color );
        Group tank1 = new Group(tank.createTank(x));
        bgThread.scheduleAtFixedRate(() -> {
            Platform.runLater(() -> {
                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5), tank1);
                tt.setToY(150);

                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), tank1);
                ft.setToValue(0);

                ParallelTransition pt = new ParallelTransition(tt, ft);
                pt.setOnFinished(e -> {
                    tank1.setTranslateY(-150);

                    TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.5), tank1);
                    tt2.setToY(0);

                    FadeTransition ft2 = new FadeTransition(Duration.seconds(0.5), tank1);
                    ft2.setToValue(1);

                    ParallelTransition pt2 = new ParallelTransition(tt2, ft2);
                    pt2.play();
                });
                pt.play();
            });
        }, 2, 5, TimeUnit.SECONDS);

        return tank1;
    }

//    private Node createMiddleContent() {
//        String title = "";
//        HBox letters = new HBox(0);
//        letters.setAlignment(Pos.CENTER);
//        for (int i = 0; i < title.length(); i++) {
//            Text letter = new Text(title.charAt(i) + "");
//            letter.setFont(FONT);
//            letter.setFill(Color.WHITE);
//            letters.getChildren().add(letter);
//
//            TranslateTransition tt = new TranslateTransition(Duration.seconds(2), letter);
//            tt.setDelay(Duration.millis(i * 50));
//            tt.setToY(-25);
//            tt.setAutoReverse(true);
//            tt.setCycleCount(TranslateTransition.INDEFINITE);
//            tt.play();
//        }
//
//        return letters;
//    }
//
//    private Node createRightContent() {
//        String title = "";
//        HBox letters = new HBox(0);
//        letters.setAlignment(Pos.CENTER);
//        for (int i = 0; i < title.length(); i++) {
//            Text letter = new Text(title.charAt(i) + "");
//            letter.setFont(FONT);
//            letter.setFill(Color.WHITE);
//            letter.setOpacity(0);
//            letters.getChildren().add(letter);
//
//            FadeTransition ft = new FadeTransition(Duration.seconds(2), letter);
//            ft.setDelay(Duration.millis(i * 50));
//            ft.setToValue(1);
//            ft.setAutoReverse(true);
//            ft.setCycleCount(TranslateTransition.INDEFINITE);
//            ft.play();
//        }
//
//        return letters;
//    }

    private MenuItem getMenuItem(int index) {
        return (MenuItem)menuBox.getChildren().get(index);
    }

    private static class ContentFrame extends StackPane {
        public ContentFrame(Node content) {
            setAlignment(Pos.CENTER);

            Rectangle frame = new Rectangle(200, 200);
            frame.setArcWidth(25);
            frame.setArcHeight(25);
            frame.setStroke(Color.WHITESMOKE);

            getChildren().addAll(frame, content);
        }
    }

    private static class MenuItem extends HBox {
        private TriCircle c1 = new TriCircle(), c2 = new TriCircle();
        private Text text;
        private Runnable script;

        public MenuItem(String name) {
            super(15);
            setAlignment(Pos.CENTER);

            text = new Text(name);
            text.setFont(FONT);
            text.setEffect(new GaussianBlur(2));

            getChildren().addAll(c1, text, c2);
            setActive(false);
            setOnActivate(() -> System.out.println(name + " activated"));
        }

        public void setActive(boolean b) {
            c1.setVisible(b);
            c2.setVisible(b);
            text.setFill(b ? Color.WHITE : Color.GREY);
        }

        public void setOnActivate(Runnable r) {
            script = r;
        }

        public void activate() {
            if (script != null)
                script.run();
        }
    }

    private static class TriCircle extends Parent {
        public TriCircle() {
            Shape shape1 = Shape.subtract(new Circle(5), new Circle(2));
            shape1.setFill(Color.WHITE);

            Shape shape2 = Shape.subtract(new Circle(5), new Circle(2));
            shape2.setFill(Color.WHITE);
            shape2.setTranslateX(5);

            Shape shape3 = Shape.subtract(new Circle(5), new Circle(2));
            shape3.setFill(Color.WHITE);
            shape3.setTranslateX(2.5);
            shape3.setTranslateY(-5);

            getChildren().addAll(shape1, shape2, shape3);

            setEffect(new GaussianBlur(2));
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                if (currentItem > 0) {
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(--currentItem).setActive(true);
                }
            }

            if (event.getCode() == KeyCode.DOWN) {
                if (currentItem < menuBox.getChildren().size() - 1) {
                    getMenuItem(currentItem).setActive(false);
                    getMenuItem(++currentItem).setActive(true);
                }
            }

            if (event.getCode() == KeyCode.ENTER) {
                getMenuItem(currentItem).activate();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> {
            bgThread.shutdownNow();
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}