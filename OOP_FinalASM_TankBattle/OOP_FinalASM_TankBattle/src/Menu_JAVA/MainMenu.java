package Menu_JAVA;

import Tank_JAVA.Tank;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainMenu {
    private final Pane root = new Pane();
    private final VBox menuBox = new VBox(-5);
    private final Setting setting= new Setting();
    private int type;
    private int color;
    private final List<Pair<String, Runnable>> menuData = Arrays.asList(
            new Pair<String, Runnable>("Start", () -> {
                System.out.println("Start activated");
            }),
            new Pair<String, Runnable>("Campaign", () -> {
                System.out.println("Campaign activated");
            }),
            new Pair<String, Runnable>("Multiplayer", () -> {
                System.out.println("Multiplayer activated");
            }),
            new Pair<String, Runnable>("Setting", () -> {
                System.out.println("Game options activated");
                try {
                    primaryStage.getStage().setScene(new Scene(setting.createSettingContent()));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }),
            new Pair<String, Runnable>("Credits", () -> {
                System.out.println("Credits");
            }),
            new Pair<String, Runnable>("Exit", Platform::exit)
    );

    private ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();

    public MainMenu() throws FileNotFoundException {
    }

    public Parent createContent() throws FileNotFoundException {

        Pane root = new Pane();
        root.setPrefSize(1280, 720);

        String imagePath = "file:src/Menu_JAVA/res/background.png";
        ImageView background = new ImageView(new Image(imagePath));

        // Tank selection display
        ContentFrame frame1 = new ContentFrame(createTankContent(20, 1, 1));
        frame1.setOnMouseClicked(e -> {
            ContentFrame frame5 = null;
            try {
                frame5 = new ContentFrame(createTankContent2(20, 1, 1));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert frame5 != null;
            frame5.setTranslateX(20);
            frame5.setTranslateY(300);
            root.getChildren().add(frame5);
            type = 1;
        });
        ContentFrame frame2 = new ContentFrame(createTankContent(20, 2, 2));
        frame2.setOnMouseClicked(e -> {
            ContentFrame frame5 = null;
            try {
                frame5 = new ContentFrame(createTankContent2(20, 2, 1));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert frame5 != null;
            frame5.setTranslateX(20);
            frame5.setTranslateY(300);
            root.getChildren().add(frame5);
            type = 2;
        });
        ContentFrame frame3 = new ContentFrame(createTankContent(20, 3, 3));
        frame3.setOnMouseClicked(e -> {
            ContentFrame frame5 = null;
            try {
                frame5 = new ContentFrame(createTankContent2(20, 3, 1));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert frame5 != null;
            frame5.setTranslateX(20);
            frame5.setTranslateY(300);
            root.getChildren().add(frame5);
            type = 3;
        });
        ContentFrame frame4 = new ContentFrame(createTankContent(20, 4, 4));
        frame4.setOnMouseClicked(e -> {
            ContentFrame frame5 = null;
            try {
                frame5 = new ContentFrame(createTankContent2(20, 4, 1));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert frame5 != null;
            frame5.setTranslateX(20);
            frame5.setTranslateY(300);
            root.getChildren().add(frame5);
            type = 4;
        });

        HBox hbox = new HBox(20, frame1, frame2, frame3, frame4);
        hbox.setTranslateX(20);
        hbox.setTranslateY(50);

        // Color pane
        Rectangle red = new Rectangle(40, 40);
        red.setFill(Color.INDIANRED);
        red.setStroke(Color.WHITESMOKE);
        red.setOnMouseClicked(e -> {
            ContentFrame frame5 = null;
            try {
                frame5 = new ContentFrame(createTankContent2(20, type, 1));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert frame5 != null;
            frame5.setTranslateX(20);
            frame5.setTranslateY(300);
            root.getChildren().add(frame5);
            color = 1;
        });
        Rectangle yellow = new Rectangle(40, 40);
        yellow.setFill(Color.YELLOW);
        yellow.setStroke(Color.WHITESMOKE);
        yellow.setOnMouseClicked(e -> {
            ContentFrame frame5 = null;
            try {
                frame5 = new ContentFrame(createTankContent2(20, type, 2));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert frame5 != null;
            frame5.setTranslateX(20);
            frame5.setTranslateY(300);
            root.getChildren().add(frame5);
            color = 2;
        });
        Rectangle green = new Rectangle(40, 40);
        green.setFill(Color.TEAL);
        green.setStroke(Color.WHITESMOKE);
        green.setOnMouseClicked(e -> {
            ContentFrame frame5 = null;
            try {
                frame5 = new ContentFrame(createTankContent2(20, type, 3));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert frame5 != null;
            frame5.setTranslateX(20);
            frame5.setTranslateY(300);
            root.getChildren().add(frame5);
            color = 3;
        });
        Rectangle blue = new Rectangle(40, 40);
        blue.setFill(Color.ROYALBLUE);
        blue.setStroke(Color.WHITESMOKE);
        blue.setOnMouseClicked(e -> {
            ContentFrame frame5 = null;
            try {
                frame5 = new ContentFrame(createTankContent2(20, type, 4));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert frame5 != null;
            frame5.setTranslateX(20);
            frame5.setTranslateY(300);
            root.getChildren().add(frame5);
            color = 4;
        });
        VBox colorPane = new VBox(5, red, yellow, green, blue);
        colorPane.setTranslateX(240);
        colorPane.setTranslateY(300);

        addMenu(900, 300);
        startAnimation();

        Text name = new Text("  TANK \nBATTLE");
        name.setTranslateX(900);
        name.setTranslateY(120);
        name.setFill(Color.GREY);
        name.setStroke(Color.WHITE);
        name.setOnMouseClicked(e -> {
            name.setFill(Color.BLACK);
        });
        name.setFont(Font.loadFont(MainMenu.class.getResource("res/Penumbra-HalfSerif-Std_35114.ttf").toExternalForm(), 100));

        MenuItem itemExit = new MenuItem("Exit");
        itemExit.setOnActivate(() -> System.exit(0));

        root.getChildren().addAll(background, hbox, menuBox, colorPane, name);
        return root;
    }

    private Node createTankContent(int x, int choice, int color) throws FileNotFoundException {
        Tank tank = new Tank(choice, color);
        Group tank1 = new Group(tank.createTank(x,1));
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

    private Node createTankContent2(int x, int choice, int color) throws FileNotFoundException {
        Tank tank = new Tank(choice, color);
        Group tank2 = new Group(tank.createTank(x,1));
        return tank2;
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

    public static class MenuItem extends Pane {
        private Runnable script;

        public MenuItem(String name) {
            Polygon bg = new Polygon(0, 0, 200, 0, 215, 15, 200, 30, 0, 30);
            bg.setStroke(Color.color(1, 1, 1, 0.75));
            bg.setEffect(new GaussianBlur());

            bg.fillProperty().bind(
                    Bindings.when(pressedProperty())
                            .then(Color.color(0, 0, 0, 0.75))
                            .otherwise(Color.color(0, 0, 0, 0.25))
            );

            Text text = new Text(name);
            text.setTranslateX(5);
            text.setTranslateY(20);
            text.setFont(Font.loadFont(MainMenu.class.getResource("res/Penumbra-HalfSerif-Std_35114.ttf").toExternalForm(), 30));
            text.setFill(Color.WHITE);

            Effect blur = new BoxBlur(1, 1, 3);
            Effect shadow = new DropShadow(5, Color.BLACK);
            text.effectProperty().bind(
                    Bindings.when(hoverProperty())
                            .then(shadow)
                            .otherwise(blur)
            );

            getChildren().addAll(bg, text);
        }

        public void setOnAction(Runnable action) {
            setOnMouseClicked(e -> action.run());
        }

        public void setOnActivate(Runnable r) {
            script = r;
        }
    }

    private void startAnimation() {
        ScaleTransition st = new ScaleTransition(Duration.seconds(1));
        st.setToY(1);
        st.setOnFinished(e -> {

            for (int i = 0; i < menuBox.getChildren().size(); i++) {
                Node n = menuBox.getChildren().get(i);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(1 + i * 0.15), n);
                tt.setToX(0);
                tt.setOnFinished(e2 -> n.setClip(null));
                tt.play();
            }
        });
        st.play();
    }

    private void addMenu(double x, double y) {
        menuBox.setTranslateX(x);
        menuBox.setTranslateY(y);
        menuData.forEach(data -> {
            MenuItem item = new MenuItem(data.getKey());
            item.setOnAction(data.getValue());
            item.setTranslateX(-200);

            Rectangle clip = new Rectangle(300, 30);
            clip.translateXProperty().bind(item.translateXProperty().negate());

            item.setClip(clip);

            menuBox.getChildren().addAll(item);
        });

        root.getChildren().add(menuBox);
    }
}


