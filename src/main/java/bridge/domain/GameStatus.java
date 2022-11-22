package bridge.domain;

public enum GameStatus {
    SUCCESS("성공"),
    CONTINUE("게임 계속 진행"),
    FAIL("실패");

    private final String title;

    GameStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
