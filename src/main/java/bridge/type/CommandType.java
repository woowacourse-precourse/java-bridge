package bridge.type;

public enum CommandType {

    QUIT("Q"),

    RETRY("R");

    private final String command;

    CommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
