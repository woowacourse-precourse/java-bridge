package bridge.constant;

public enum RetryCommand {
    RETRY("R"),
    QUIT("Q");

    private String shortcut;

    RetryCommand(String shortcut) {
        this.shortcut = shortcut;
    }

    public static boolean contains(String userInput) {
        return RETRY.shortcut.equals(userInput) || QUIT.shortcut.equals(userInput);
    }

    public static boolean canRetry(String userInput) {
        return RETRY.shortcut.equals(userInput);
    }
}
