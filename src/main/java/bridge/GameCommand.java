package bridge;

public enum GameCommand {

    RETRY("R"),
    QUIT("Q");

    private final String mark;

    GameCommand(String mark) {
        this.mark = mark;
    }

    public static boolean isRetry(GameCommand userCommand) {
        return userCommand == GameCommand.RETRY;
    }
}
