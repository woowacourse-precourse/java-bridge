package bridge.enums;

public enum Number {
    FIRST(0), SECOND(1);

    private int message;

    Number(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }
}
