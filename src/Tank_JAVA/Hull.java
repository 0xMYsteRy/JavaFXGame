package Tank_JAVA;

import java.io.Serializable;

/*MAC: --module-path "/Users/s3757937/Downloads/javafx-sdk-11.0.2/lib" --add-modules javafx.controls,javafx.fxml*/
public class Hull implements Serializable {
    private int color = 1;
    private int type;

    Hull(int Color, int Type) {
        this.color = Color;
        this.type = Type;
    }

    public String getHull() {
        String colorPath;
        switch (color) {
            case 1:
                colorPath = "A";
                break;
            case 2:
                colorPath = "B";
                break;
            case 3:
                colorPath = "C";
                break;
            case 4:
                colorPath = "D";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + color);
        }

        return "file:" + "src/PNG/Hulls_Color_" + colorPath + "/Hull_0" + type + ".png";
    }
}
