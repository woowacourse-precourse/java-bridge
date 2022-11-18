package bridge.exception;

public class NumberOutOfRangeException extends IllegalArgumentException {

    private static final String MESSAGE = "3 ~ 20 범위의 숫자만 입력이 가능합니다.";

    public NumberOutOfRangeException(){
        super(MESSAGE);
    }
}
