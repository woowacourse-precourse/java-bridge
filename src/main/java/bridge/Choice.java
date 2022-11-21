package bridge;

public enum Choice {
    UP("U", 1),
    DOWN("D", 0);

    private String gameCommand;
    private int commandNumber;

    Choice(String gameCommand, int commandNumber) {
        this.gameCommand = gameCommand;
        this.commandNumber = commandNumber;
    }

    public String getGameCommand() {
        return gameCommand;
    }

    public int getCommandNumber() {
        return commandNumber;
    }
}
