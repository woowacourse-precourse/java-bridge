package bridge.command;

/**
 * 재시도, 종료를 선택하는 입력을 받는 커맨드 객체입니다
 */
public class RetryCommand {
    private static final String NULL_MESSAGE = "입력에 null이 들어왔습니다";
    private final String retry;

    public RetryCommand(final String retry) {
        this.retry = retry;
        validate();
    }

    private void validate() {
        if (isNull()) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    private boolean isNull() {
        return retry == null;
    }

    public String getRetry() {
        return retry;
    }
}
