package bridge;

public enum MessageForOutput {
    MAP_STARTING("["),
    MAP_ENDING("]"),
    FAIL_MARK("X"),
    SEPARATOR("|"),
    SUCCESS_MARK("O"),
    MAP_BLANK(" ");

    final String message;
    MessageForOutput(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
