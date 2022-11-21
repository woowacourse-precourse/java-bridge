package bridge;

public enum BridgeException {
    TOKEN("[ERROR]");

    private final String message;

    BridgeException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
