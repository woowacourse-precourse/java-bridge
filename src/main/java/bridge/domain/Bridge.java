package bridge.domain;

public enum Bridge {
    MIN_LENGTH(3),
    MAX_LENGTH(20),
    START_INDEX(0);


    final private int value;

    Bridge(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
