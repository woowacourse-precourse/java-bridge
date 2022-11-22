package bridge.constant;

public enum UpDown {
    DOWN("D", 0),
    UP("U", 1);

    private final String name;
    private final int value;

    private UpDown(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
