package bridge.position;

import java.util.Objects;

public class Position {
    private int longitude;
    private Latitude latitude;

    public Position() {
        this.longitude = -1;
        latitude = null;
    }

    public Position(int longitude, Latitude latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Position position = (Position) other;
        return longitude == position.longitude && latitude == position.latitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude);
    }

    public int addLongitude() {
        return ++longitude;
    }

    public void changeLatitude(Latitude latitude) {
        this.latitude = latitude;
    }

    public Latitude getLatitude() {
        return latitude;
    }

    public void init() {
        this.longitude = -1;
        latitude = null;
    }
}
