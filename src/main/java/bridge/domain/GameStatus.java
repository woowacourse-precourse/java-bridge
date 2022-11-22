package bridge.domain;

public enum GameStatus {
    WIN("성공"), CONTINUE(""), OVER("실패");

    private final String message;

    GameStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
