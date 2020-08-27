package Tank;

class Hull {
    private int color;
    private int type;

    Hull(int Color, int Type) {
        this.color = Color;
        this.type = Type;
    }

    public String getHull() {
        String colorPath = "";
        switch (color) {
            case 1:
                colorPath = "A";
            case 2:
                colorPath = "B";
            case 3:
                colorPath = "C";
            case 4:
                colorPath = "D";
        }
        return "src/PNG/Hulls_Color_" + colorPath + "/Hull_0" + type + ".png";
    }
}

class Weapon {
    private int color;
    private int Option;

    Weapon(int Color, int Option) {
        this.color = Color;
        this.Option = Option;
    }

    public String getWeapon() {
        String colorPath = "";
        switch (color) {
            case 1:
                colorPath = "A";
            case 2:
                colorPath = "B";
            case 3:
                colorPath = "C";
            case 4:
                colorPath = "D";
        }
        return "src/PNG/Weapon_Color_" + colorPath + "/Gun_0" + Option + ".png";
    }
}

class Track {
    private final float duration = 1;
    private int Option;

    Track(int Option) {
        this.Option = Option;
    }

    public String getTrackPath(int TrackPathOption) {
        return "src/PNG/Effects/Tire_Track_0" + TrackPathOption + ".png";
    }

    public String getTrack(String Animation) {
        return "src/PNG/Tracks/Track_" + Option + "_" + Animation + ".png";
    }
}

class Bullet {
    private int Damage;
    private int Speed;
    private int Effect;
    private double RealoadRate;
    private int Ammunition;
    private int Range;
    private String ImagePath;
    Bullet(int bulletOption){
        switch (bulletOption){
            case 1:
                Damage= 15;
                Speed=12;
                Effect=1;
                RealoadRate= 0.2;
                Ammunition = 20;
                Range=10;
            case 2:
                Damage= 30;
                Speed=10;
                Effect=1;
                RealoadRate= 0.5;
                Ammunition = 10;
                Range=12;
            case 3:
                Damage= 50;
                Speed=15;
                Effect=1;
                RealoadRate= 1;
                Ammunition = 5;
                Range=15;
            case 4:
                Damage=90;
                Speed=0;
                Effect=2;
                RealoadRate=0;
                Ammunition=0;
                Range=1;
        }
    }
    public void SetDamage(int Value){

    }
}

public class Tank {
    private final int tankOption;
    private int speed;
    private boolean alive;
    private int health;
    private int defense;

    Tank(int tankOption) {
        this.tankOption = tankOption;
    }

    void getTank() {
        switch (tankOption) {
            case 1:
                speed = 50;
                health = 50;
                defense = 50;
                speed = 50;
            case 2:
                speed = 60;
                health = 60;
                defense = 60;
                speed = 60;
            case 3:
                speed = 70;
                health = 70;
                defense = 70;
                speed = 70;
            case 4:
                speed = 80;
                health = 80;
                defense = 80;
                speed = 80;
        }
    }
}public class Tank {
    private int speed;
    private boolean alive;
    private int health;
    private int defense;
    private int speed;

    Tank(int tankOption) {
        this.tankOption = tankOption;
    }

    getTank() {
        switch (tankOption) {
            case 1:
                speed = 50;
                health = 50;
                defense = 50;
                speed = 50;
            case 2:
                speed = 60;
                health = 60;
                defense = 60;
                speed = 60;
            case 3:
                speed = 70;
                health = 70;
                defense = 70;
                speed = 70;
            case 4:
                speed = 80;
                health = 80;
                defense = 80;
                speed = 80;
        }
    }
}
