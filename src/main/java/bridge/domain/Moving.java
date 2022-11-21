package bridge.domain;

public enum Moving {
    DOWN("D"),
    UP("U");

    private final String command;

    Moving(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
