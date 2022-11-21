package bridge.exception;

public class MovingDirectionFormatException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] 이동할 칸은 U/D 중에서 선택해야 합니다.";

    public MovingDirectionFormatException() {
        super(ERROR_MESSAGE);
    }
}
