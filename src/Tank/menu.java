//package Tank;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.effect.GaussianBlur;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//public class menu extends Application {
//
//    static final Font FONT = Font.font("", FontWeight.BOLD, 18);
//
//    private VBox menuBox;
//    private int currentItem = 0;
//
//    private ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();
//
//    // Create content for the menu
//    private Parent createContent() {
//        Pane root = new Pane();
//        root.setPrefSize(1000,700);
//
//        Rectangle background = new Rectangle(1000, 700);
//
//        // Optional UI effect
//        ContentFrame frame1 = new ContentFrame(createLeftContent());
//        ContentFrame frame2 = new ContentFrame(createMiddleContent());
//        ContentFrame frame3 = new ContentFrame(createRightContent());
//
//        HBox hbox = new HBox(15, frame1, frame2, frame3);
//        hbox.setTranslateX(120);
//        hbox.setTranslateY(50);
//
//        MenuItem itemExit = new MenuItem("EXIT");
//        itemExit.setOnActivate(() -> System.exit(0));
//
//        menuBox = new VBox(10,
//                new MenuItem("Start"),
//                new MenuItem("Campaign"),
//                new MenuItem("Multiplayer"),
//                new MenuItem("Setting"),
//                itemExit);
//        menuBox.setAlignment(Pos.TOP_CENTER);
//        menuBox.setTranslateX(360);
//        menuBox.setTranslateY(300);
//
//        Text logo = new Text("Tank Battle\n\t by \n Blanc Production");
//        logo.setTranslateX(50);
//        logo.setTranslateY(500);
//        logo.setFill(Color.WHITE);
//        logo.setFont(FONT);
//        logo.setOpacity(0.5);
//
//        getMenuItem(0).setActive(true);
//
//        root.getChildren().addAll(background, menuBox, logo);
//        return root;
//    }
//
//    private Node createLeftContent() {}
//
//    private Node createMiddleContent() {}
//
//    private Node createRightContent() {}
//
//    private static class ContentFrame extends StackPane {
//        public ContentFrame(Node content) {
//            setAlignment(Pos.CENTER);
//
//            Rectangle frame = new Rectangle(200,200);
//            frame.setArcWidth(25);
//            frame.setArcHeight(25);
//            frame.setStroke(Color.WHITESMOKE);
//
//            getChildren().addAll(frame, content);
//        }
//    }
//
//    private static class MenuItem extends HBox {
//        private Circle c1 = new Circle(), c2 = new Circle();
//        private Text text;
//        private Runnable script;
//
//        public MenuItem(String name) {
//            super(15);
//            setAlignment(Pos.CENTER);
//
//            text = new Text(name);
//            text.setFont(FONT);
//            text.setEffect(new GaussianBlur(2));
//
//            getChildren().addAll(c1, text, c2);
//            setActive(false);
//            setOnActivate();
//        }
//
//        public void setActive(boolean b) {
//            c1.setVisible(b);
//            c2.setVisible(b);
//            text.setFill(b ? Color.WHITE: Color.GREY);
//        }
//
//        public void setOnActivate(Runnable r) {
//            script = r;
//        }
//
//        public void activate() {
//            if (script != null)
//                script.run();
//        }
//
//    }
//
//    private Node getMenuItem(int index) {
//        return (MenuItem)menuBox.getChildren().get(index);
//    }
//
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Scene scene = new Scene(createContent());
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.UP) {
//                if (currentItem > 0) {
//                    getMenuItem(currentItem).setActive(false);
//                    getMenuItem(--currentItem).setActive(true);
//                }
//            }
//            if (event.getCode() == KeyCode.DOWN) {
//                if (currentItem < menuBox.getChildren().size() - 1) {
//                    getMenuItem(currentItem).setActive(false);
//                    getMenuItem(++currentItem).setActive(true);
//                }
//            }
//            if (event.getCode() == KeyCode.ENTER) {
//                getMenuItem(currentItem).activate();
//            }
//        });
//
//        primaryStage.setScene(scene);
//        primaryStage.setOnCloseRequest(event -> {
//            bgThread.shutdownNow();
//        });
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
