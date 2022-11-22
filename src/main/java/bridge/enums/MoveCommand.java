package bridge.enums;

public enum MoveCommand {
    UP("U"),
    DOWN("D");

    private final String commandStr;

    MoveCommand(String commandStr) {
        this.commandStr = commandStr;
    }

    public String getCommandStr() {
        return commandStr;
    }
}
