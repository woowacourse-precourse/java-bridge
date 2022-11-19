package bridge;

public enum Move {
    D(0),
    U(1);

    private final int order;

    Move(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
