package bridge.exception;

public class InputInvalidMovingException extends IllegalArgumentException{
    public InputInvalidMovingException() {
        super("[ERROR] 이동은 U 또는 D만 입력 가능합니다.");
    }
}