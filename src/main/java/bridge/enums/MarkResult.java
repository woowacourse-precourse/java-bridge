package bridge.enums;

public enum MarkResult {
    MARK_CORRECT("O"), MARK_INCORRECT("X"), SUCCESS("성공"), FAIL("실패");

    private String message;

    MarkResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
