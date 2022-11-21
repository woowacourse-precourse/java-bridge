package bridge.constant;

public enum GameCommand {
    GO_UP("U"),
    GO_DOWN("D"),
    RESTART("R"),
    QUIT("Q");

    private final String gameCommand;

    GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public String getGameCommand() {
        return gameCommand;
    }

}
