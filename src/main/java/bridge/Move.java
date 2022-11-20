package bridge;

public enum Move {
    D(1),
    U(0);

    private final int location;

    Move(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }
}
