package bridge.exception;

public class InputNotDigitException extends IllegalArgumentException{
    public InputNotDigitException() {
        super("[ERROR] 자연수를 입력해야 합니다.");
    }
}