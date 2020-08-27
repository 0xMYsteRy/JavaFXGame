package Tank;

import java.util.Optional;

class Hull{
    private int color;
    private int type;
    private String imagepath;
    Hull(int Color, int Type){
        this.color=Color;
        this.type=Type;
    }
    public String getHull(){
        String colorPath="";
        switch (color){
            case 1:
                colorPath="A";
            case 2:
                colorPath="B";
            case 3:
                colorPath="C";
            case 4:
                colorPath="D";
        }
        return "src/PNG/Hulls_Color_"+colorPath+"/Hull_0"+type+".png";
    }
}
class Weapon{
    private int color;
    private int Option;
    private String imagepath;
    Weapon(int Color, int Option){
        this.color=Color;
        this.Option= Option;
    }
    public String getWeapon(){
        String colorPath="";
        switch (color){
            case 1:
                colorPath="A";
            case 2:
                colorPath="B";
            case 3:
                colorPath="C";
            case 4:
                colorPath="D";
        }
        return "src/PNG/Weapon_Color_"+colorPath+"/Gun_0"+Option+".png";
    }
}
class Track{
    private float duration;
    private int Option;
    private String TrackImagePath;
    private String TrackPathImagePath;

    Track( int Option){
        this.Option= Option;
    }
    public String getTrackPath(String track1,String track2){
        return "src/PNG/Effects/Tire_Track_0"+Option+".png";
    }
    public String getTrack(String track1,String track2){
        return "src/PNG/Tracks/Track_"+track1+"_"+track2+".png";
    }
}
public class Tank {
}
