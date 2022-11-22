package bridge.input;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String input;

    GameCommand(String input) {
        this.input = input;
    }

    public String getSymbol() {
        return input;
    }

    public static GameCommand getGameCommand(String input) {
        if (input.equals(RETRY.input)) {
            return RETRY;
        }
        return QUIT;
    }
}
