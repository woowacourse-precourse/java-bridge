package bridge.model.constant;

public enum Status {
    GAME_FINISHED("성공"),
    GAME_OVER("실패"),
    GAME_PROCESSING("실패");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
