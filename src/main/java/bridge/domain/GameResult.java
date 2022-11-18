package bridge.domain;

public enum GameResult {
    SUCCESS("성공"),
    FAIL("실패");

    private String name;

    GameResult() {
    }

    GameResult(String name) {
        this.name = name;
    }
}
