package bridge.model;

public enum BlockStatus {
    O(" O "), X(" X "), UNSELECT("   ");

    private final String status;

    BlockStatus(String status) {
        this.status = status;
    }

    public static BlockStatus of(boolean correct) {
        if (correct) return O;
        return X;
    }

    @Override
    public String toString() {
        return this.status;
    }
}
