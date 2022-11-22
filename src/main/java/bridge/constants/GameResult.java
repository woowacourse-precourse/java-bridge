package bridge.constants;

public enum GameResult {
    SUCCESS("성공"),
    FAIL("실패");

    private final String result;

    GameResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}
