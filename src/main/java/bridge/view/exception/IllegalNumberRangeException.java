package bridge.view.exception;

public class IllegalNumberRangeException extends IllegalArgumentException{

    public IllegalNumberRangeException(String s, Integer size) {
        super(s + size);
    }

}
