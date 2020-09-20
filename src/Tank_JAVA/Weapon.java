package Tank_JAVA;

import java.io.Serializable;

public class Weapon implements Serializable {
    private int color;
    private int Option;

    Weapon(int Color, int Option) {
        this.color = Color;
        this.Option = Option;
    }

    public String getWeapon() {
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

        return "file:" + "src/PNG/Weapon_Color_" + colorPath + "/Gun_0" + Option + ".png";
    }
}
