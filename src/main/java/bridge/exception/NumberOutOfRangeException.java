package bridge.exception;

public class NumberOutOfRangeException extends IllegalArgumentException {

    private static final String MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public NumberOutOfRangeException(){
        super(MESSAGE);
    }
}
