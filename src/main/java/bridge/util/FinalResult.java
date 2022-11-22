package bridge.util;

public enum FinalResult {
    WIN("성공"),
    LOSE("실패");

    private final String message;

    FinalResult(String message) {
        this.message = message;
    }

    public static String of(boolean result) {
        if (result) {
            return WIN.message;
        }
        return LOSE.message;
    }
}