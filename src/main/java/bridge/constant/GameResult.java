package bridge.constant;

public enum GameResult {
    SUCCESS("성공"),
    FAILURE("실패");

    private final String value;

    GameResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
