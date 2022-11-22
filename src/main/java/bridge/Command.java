package bridge;

public enum Command {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q");

    private final String commandStr;

    Command(String commandStr) {
        this.commandStr = commandStr;
    }

    public String getCommandStr() {
        return commandStr;
    }

}
