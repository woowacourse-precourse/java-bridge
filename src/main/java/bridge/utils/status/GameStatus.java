package bridge.utils.status;

public enum GameStatus {

    WIN("성공"),
    LOSE("실패"),
    PLAYING("진행중");

    private final String message;

    GameStatus(String message) {
        this.message = message;
    }

    private String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
    
}
