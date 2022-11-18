package bridge.view;

public enum MoveResultDisplay {
    SUCCESS("성공", "O"),
    FAIL("실패", "X");
    
    private final String gameResult;
    private final String movingResult;
    
    MoveResultDisplay(final String gameResult, final String movingResult) {
        this.gameResult = gameResult;
        this.movingResult = movingResult;
    }
    
    public String getGameResult() {
        return gameResult;
    }
    
    public String getMovingResult() {
        return movingResult;
    }
}
