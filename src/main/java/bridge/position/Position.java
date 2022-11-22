package bridge.position;

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

    public boolean equals(Position other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return longitude == other.longitude && latitude.equals(other.latitude);
    }

    public int addLongitude() {
        return ++longitude;
    }

    public void changeLatitude(Latitude latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public Latitude getLatitude() {
        return latitude;
    }
}
