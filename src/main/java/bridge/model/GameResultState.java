package bridge.model;

public enum GameResultState {
    WIN("성공"), LOSE("실패");

    private final String message;

    GameResultState(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
