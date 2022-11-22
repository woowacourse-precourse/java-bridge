package bridge;

public enum GameResult {
    SUCCESS("성공"),
    FAIL("실패");

    private final String value;

    GameResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
