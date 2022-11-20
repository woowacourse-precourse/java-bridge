package bridge.exception;

public class BridgeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] : ";

    public BridgeException(String message) {
        super(ERROR_MESSAGE + message);
    }
}
