package bridge.game;

public enum BridgeGameStatus {
    RUNNING("진행중"),
    STOP("실패"),
    FINISH("성공");

    private final String text;

    BridgeGameStatus(String text) {
        this.text = text;
    }

    public String text() {
        return this.text;
    }
}
