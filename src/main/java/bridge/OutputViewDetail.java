package bridge;

public enum OutputViewDetail {
    CAN_MOVE(" O "),
    CANNOT_MOVE(" X "),
    NONE("   "),
    START_LINE("["),
    MIDDLE_LINE("|"),
    END_LINE("]");

    private final String message;

    OutputViewDetail(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
