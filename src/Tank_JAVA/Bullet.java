package Tank_JAVA;

import java.io.Serializable;

public class Bullet implements Serializable {
    private int counting = 0;
    private int Damage = 0;
    private int Speed = 0;
    private int Effect = 0;
    private double RealoadRate = 0;
    private int Ammunition = 0;
    private int Range = 0;
    private String ImagePath = "file:src/PNG/Effects/Exhaust_Fire.png";
    private String ImagePath2 = "file:src/PNG/Effects/Plasma.png";

    public Bullet() {
    }

    public Bullet(int bulletOption) {
        switch (bulletOption) {
            case 1:
                this.Damage = 15;
                this.Speed = 12;
                this.Effect = 1;
                this.RealoadRate = 0.2;
                this.Ammunition = 20;
                this.Range = 10;
                break;
            case 2:
                this.Damage = 11;
                this.Speed = 10;
                this.Effect = 1;
                this.RealoadRate = 0.5;
                this.Ammunition = 10;
                this.Range = 12;
                break;
            case 3:
                this.Damage = 24;
                this.Speed = 15;
                this.Effect = 1;
                this.RealoadRate = 1;
                this.Ammunition = 5;
                this.Range = 15;
                break;
            case 4:
                this.Damage = 22;
                this.Speed = 16;
                this.Effect = 2;
                this.RealoadRate = 0;
                this.Ammunition = 0;
                this.Range = 19;
                break;
            case 5:
                this.Damage = 15;
                this.Speed = 12;
                this.Effect = 1;
                this.RealoadRate = 0.2;
                this.Ammunition = 10;
                this.Range = 10;
                break;
            case 6:
                this.Damage = 20;
                this.Speed = 10;
                this.Effect = 1;
                this.RealoadRate = 0.5;
                this.Ammunition = 14;
                this.Range = 12;
                break;
            case 7:
                this.Damage = 18;
                this.Speed = 15;
                this.Effect = 1;
                this.RealoadRate = 1;
                this.Ammunition = 7;
                this.Range = 15;
                break;
            case 8:
                this.Damage = 20;
                this.Speed = 19;
                this.Effect = 2;
                this.RealoadRate = 0;
                this.Ammunition = 0;
                this.Range = 20;
                break;
            default:
                System.out.println("Damn, Wrong Bullet option " + bulletOption);
                break;
        }
    }

    private int x, y;
    private Boolean BulletAlive;

    public void SetDamage(int Value) {

    }

    public int getDamage() {
        return Damage;
    }

    public void SetReload(int Value) {

    }

    public double getReload() {
        return RealoadRate;
    }

    public String getBullet(int choice) {
        counting += 1;
//        System.out.printf("Shot %d bullets\n", counting);
        switch (choice % 3) {
            case 1:
                return ImagePath;
            case 2:
                return ImagePath2;
            default:
                return ImagePath;
        }
    }

    public void setAmmunition(int Amount) {
        Ammunition += Amount;
    }

    public int getAmmunition() {
        return Ammunition;
    }

    public int getRange() {
        return Range;
    }

    public int getSpeed() {
        return Speed;
    }

}
