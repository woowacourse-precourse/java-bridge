package bridge.exception;

public class InputInvalidCommandException extends IllegalArgumentException{
    public InputInvalidCommandException() {
        super("[ERROR] 입력은 R 또는 Q만 가능합니다.");
    }
}
