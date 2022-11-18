package bridge;

public enum Command {
    UP("U"), DOWN("D"),RETRY("R"), EXIT("Q"),
    ;

    private String key;

    Command(String key) {
        this.key = key;
    }
}
