package bridge.constant;

public enum RetryCommand {
    RETRY("R"),
    QUIT("Q");

    public static boolean contains(String userInput) {
        return RETRY.shortcut.equals(userInput) || QUIT.shortcut.equals(userInput);
    }

    public static boolean canRetry(String userInput) {
        return RETRY.shortcut.equals(userInput);
    }

    private final String shortcut;

    RetryCommand(String shortcut) {
        this.shortcut = shortcut;
    }
}
