package constants;

public enum GameCommand {
    DOWN("D"),
    UP("U"),
    END("Q"),
    RESTART("R");

    private String gameCommand;

    GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}