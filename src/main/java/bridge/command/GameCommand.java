package bridge.command;

public enum GameCommand {

    Restart("R"),
    Quit("Q");

    private String gameCommand;

    GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
