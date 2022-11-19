package bridge.domain;

public enum RetryCommand {

    RETRY("R"),
    QUIT("Q");

    private static final String ERROR_RETRY_INPUT = "재시도 여부는 R, Q만 입력 가능합니다";
    private final String name;

    RetryCommand(String name) {
        this.name = name;
    }

    public static RetryCommand nameOf(String input) {
        for (RetryCommand retryCommand : RetryCommand.values()) {
            String name = retryCommand.name;
            if (name.equals(input)) {
                return retryCommand;
            }
        }
        throw new IllegalArgumentException(ERROR_RETRY_INPUT);
    }
}
