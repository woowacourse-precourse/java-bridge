package bridge.Messages;

public enum Error {
    INVALID_NOTANUMBER("Input is not a number"),
    INVALID_LENGTH("Wrong bridge length input"),
    INVALID_LETTER("Invalid letter input"),
    INVALID_RANGE("Invalid range of input number");
    private final String message;
    Error(final String message) {
        this.message = "[ERROR] " + message;
    }
    public String getMessage() {
        return message;
    }
}
