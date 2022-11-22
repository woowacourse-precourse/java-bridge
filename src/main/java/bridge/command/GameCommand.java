package bridge.command;

public enum GameCommand {

    Restart("R"),
    Quit("Q");

    private String gameCommand;

    GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public static boolean isRestart(String userInput) {
        return Restart.gameCommand.equals(userInput);
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
