package bridge.exception;

public class NotInputFormatException extends IllegalArgumentException {
    public NotInputFormatException() {
        super("[ERROR] 입력 형식이 맞지 않습니다.");
    }
}
