package bridge;

public enum CommandType {
    RESTART("R"),
    QUIT("Q");

    private final String commands;

    CommandType(String commands) {
        this.commands = commands;
    }

    public String getCommands() {
        return this.commands;
    }
}
