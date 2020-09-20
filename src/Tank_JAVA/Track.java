package Tank_JAVA;

import java.io.Serializable;

public class Track implements Serializable {
    private final float duration = 1;
    private int Option;

    Track(int Option) {
        this.Option = (Option - 1) % 3 + 1;

    }

    public String getTrackPath(int TrackPathOption) {

        return "file:src/PNG/Effects/Tire_Track_0" + TrackPathOption + ".png";
    }

    public String getTrack() {
        return "file:src/PNG/Tracks/Track_" + Option + "_A.png";
    }
}
