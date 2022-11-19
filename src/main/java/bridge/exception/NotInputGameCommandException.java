package bridge.exception;

public class NotInputGameCommandException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 게임 재시작 여부에 대해 입력해주세요.";

    public NotInputGameCommandException() {
        super(MESSAGE);
    }
}
