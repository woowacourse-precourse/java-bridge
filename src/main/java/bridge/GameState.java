package bridge;

public enum GameState {
    PLAYING("진행중"),
    FAIL("실패"),
    SUCCESS("성공");

    private final String message;

    GameState(String message) {
        this.message = message;
    }
}
