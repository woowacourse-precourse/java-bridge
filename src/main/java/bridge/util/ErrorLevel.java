package bridge.util;

public enum ErrorLevel {

    ERROR("[ERROR] "),
    WARN("[WARN] "),
    INFO("[INFO] "),
    DEBUG("[DEBUG] "),
    TRACE("[TRACE] "),
    ;

    private String message;

    ErrorLevel(String message) {
        this.message = message;
    }

    public String toMessage() {
        return message;
    }
}
