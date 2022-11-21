package bridge.type;

public enum RestartType {
    RESTART("R"),
    QUIT("Q");

    private final String commands;

    RestartType(String commands) {
        this.commands = commands;
    }

    public String getCommands() {
        return this.commands;
    }
}
