package bridge.domain.model;

public enum GameResult {
    WIN("성공"),
    LOSE("실패");

    private final String result;

    GameResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
