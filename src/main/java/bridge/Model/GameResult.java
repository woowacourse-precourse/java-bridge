package bridge.Model;

public enum GameResult {
    SUCCESS("O"), FAIL("X"), RETRY("R"), QUIT("Q");

    private final String result;

    GameResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
