package bridge;

public enum Location {
    UP("U", 1),
    DOWN("D", 0);

    private final String status;
    private final int number;

    Location(String status, int positionNumber) {
        this.status = status;
        this.number = number;
    }

    public String get(Location location) {
        return location.status;
    }
}
