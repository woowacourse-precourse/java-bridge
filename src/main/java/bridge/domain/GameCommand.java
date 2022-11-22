package bridge.domain;

public enum GameCommand {

    QUIT("Q"),
    RETRY("R");

    private final String gameCommand;

    GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
