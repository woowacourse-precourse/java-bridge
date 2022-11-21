package bridge.constant;

public enum RetryCommand {
    RETRY("R"),
    QUIT("Q");

    public static final String INVALID_RETRY_COMMAND_INPUT_MSG = "유효하지 않은 게임 재시작 명령입니다. (재시도: R, 종료: Q)";

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
