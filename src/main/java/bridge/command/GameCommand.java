package bridge.command;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    private String gameCommand;

    GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
