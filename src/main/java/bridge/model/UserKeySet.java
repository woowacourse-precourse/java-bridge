package bridge.model;

public enum UserKeySet {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private final String key;
    UserKeySet(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
