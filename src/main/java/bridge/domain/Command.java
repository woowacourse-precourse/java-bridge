package bridge.domain;

public enum Command {
    UP("U"), DOWN("D"),RETRY("R"), EXIT("Q"),
    ;

    private String key;

    Command(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
