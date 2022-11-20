package bridge;

public enum Move {
    D(1, "D"),
    U(0, "U");

    private final int order;
    private final String location;

    Move(int order, String location) {
        this.order = order;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public int getOrder() {
        return order;
    }
}
