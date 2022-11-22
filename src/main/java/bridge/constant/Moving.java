package bridge.constant;

public enum Moving {
    UP("U"),
    DOWN("D");

    private final String key;

    Moving(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
