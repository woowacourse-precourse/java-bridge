package bridge.exception;

public class CheckUpDownException extends IllegalArgumentException {
    public CheckUpDownException() {
        super("[ERROR] U or D 를 입력해주세요");
    }
}
