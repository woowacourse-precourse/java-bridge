package bridge.enums;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String gameCommand;

    GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public String getCommand() {
        return gameCommand;
    }
}
