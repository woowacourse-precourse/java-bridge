package bridge.exception;

public class InputNotNumberException extends IllegalArgumentException{
    private static final String MESSAGE = "입력 값이 숫자가 아닙니다.";

    public InputNotNumberException(){
        super(MESSAGE);
    }
}
