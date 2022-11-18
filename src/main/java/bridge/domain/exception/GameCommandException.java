package bridge.domain.exception;

public class GameCommandException extends IllegalArgumentException {

    public GameCommandException() {
    }

    public GameCommandException(String s) {
        super(s);
    }
}
