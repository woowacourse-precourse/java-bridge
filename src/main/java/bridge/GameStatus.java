package bridge;

public enum GameStatus {

    LOSE("실패"),
    SUCCESS("성공"),

    PROGRESS("진행중");

    private final String status;
    GameStatus(String status) {
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
}
