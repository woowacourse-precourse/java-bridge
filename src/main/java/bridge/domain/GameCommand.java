package bridge.domain;

public enum GameCommand {
    END("Q"),
    RESTART("R");

    private final String gameCommand;

    GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
