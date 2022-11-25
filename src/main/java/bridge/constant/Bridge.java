package bridge.constant;

public enum Bridge {
    MIN(3),
    MAX(20);

    private final int number;

    private Bridge(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
