package bridge.constant;

public enum Updown {
    UP("U"),
    DOWN("D");

    private final String key;

    Updown(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
