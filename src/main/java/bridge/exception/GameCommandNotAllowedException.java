package bridge.exception;

public class GameCommandNotAllowedException extends IllegalArgumentException {

    private static final String MESSAGE = "[ERROR] Q또는 R만 입력할 수 있습니다.";

    public GameCommandNotAllowedException() {
        super(MESSAGE);
    }
}
