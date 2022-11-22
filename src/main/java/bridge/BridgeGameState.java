package bridge;

public enum BridgeGameState {
    PLAYING("진행중"),
    FAIL("실패"),
    CLEAR("성공");

    private final String text;

    BridgeGameState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
