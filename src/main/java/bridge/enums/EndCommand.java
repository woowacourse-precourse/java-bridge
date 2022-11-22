package bridge.enums;

public enum EndCommand {
    RESTART("R"),
    QUIT("Q");

    private final String commandStr;

    EndCommand(String commandStr) {
        this.commandStr = commandStr;
    }

    public String getCommandStr() {
        return commandStr;
    }

}
