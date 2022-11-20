package bridge.Model;

public enum GameResult {
    SUCCESS("O"), FAIL("X");

    private final String result;

    GameResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
