package bridge;

public enum GameStatus {
    DOING("게임중"), SUCCESS("성공"), FAIL("실패");

    private final String gameStatusMessage;

    private GameStatus(String gameStatusMessage) {
        this.gameStatusMessage = gameStatusMessage;
    }

    public String getGameStatusMessage() {
        return this.gameStatusMessage;
    }
}
