package bridge.constant;

public enum GameStatus {
    READY("준비"),
    IN_PROGRESS("진행중"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String korean;

    GameStatus(String korean){
        this.korean = korean;
    }

    public String korean(){
        return korean;
    }
}