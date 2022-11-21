package bridge.game;

public enum Result {
    FAIL(" X ", "실패"),
    SUCCESS(" O ", "성공"),
    CONTINUE("   ", "계속"),
    NONE("   ", "해당없음");

    private final String print;
    private final String message;

    Result(String print, String message) {
        this.print = print;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return print;
    }
}
