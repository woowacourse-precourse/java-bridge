package bridge.enums;

public enum GameCommand {
    QUIT("Q"),
    RETRY("R"),
    MOVE_UP("U"),
    MOVE_DOWN("D");

    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public boolean isSame(String command) {
        return this.command.equals(command);
    }

    public String getValue() {
        return this.command;
    }
}
