package bridge.domain;

public enum Command {
    UP("U"), DOWN("D"), RETRY("R"), QUIT("Q");

    final private String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
