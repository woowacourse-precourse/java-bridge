package bridge;

public enum GameSetting {
    MIN_BRIDGE_SIZE(3),
    MAX_BRIDGE_SIZE(20);

    private final int value;

    GameSetting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
