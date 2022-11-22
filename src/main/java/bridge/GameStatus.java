package bridge;

public enum GameStatus {

    WIN("성공"),
    LOSE("실패"),
    CONTINUE("계속");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return status;
    }
}
