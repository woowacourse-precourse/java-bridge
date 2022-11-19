package bridge;

public enum Command {
    SUCCESS("성공"),
    FAIL("실패"),
    RESULT_SUCCESS("O"),
    RESULT_FAIL("X"),
    UP("U"),
    RETRY("R"),
    BLANK_SPACE(" ");

    private final String message;

    Command(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isEquals(String message) {
        return this.message.equals(message);
    }
}
