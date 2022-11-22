package bridge.model;

public enum GameCommandFlag {
    RETRY("R"),
    QUIT("Q"),
    NOTHING(" ");

    private final String gameCommand;

    GameCommandFlag(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public static GameCommandFlag toString(String gameCommand) {
        if (gameCommand.equals(RETRY.gameCommand)) {
            return RETRY;
        }
        if (gameCommand.equals(QUIT.gameCommand)) {
            return QUIT;
        }
        return NOTHING;
    }
}
