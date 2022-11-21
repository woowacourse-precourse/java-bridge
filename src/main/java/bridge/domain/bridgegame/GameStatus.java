package bridge.domain.bridgegame;

public class GameStatus {
    private final String SUCCESS_VALUE = "성공";
    private final String FAILURE_VALUE = "실패";
    private final StringBuilder upBridge;
    private final StringBuilder downBridge;
    private final int gameTrialCount;
    private final String winOrLose;

    public GameStatus(StringBuilder upBridge, StringBuilder downBridge, int gameTrialCount, boolean winOrLose) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
        this.gameTrialCount = gameTrialCount;
        this.winOrLose = makeWinOrLose(winOrLose);
    }

    private String makeWinOrLose(boolean winOrLose) {
        if (winOrLose) {
            return SUCCESS_VALUE;
        }
        return FAILURE_VALUE;
    }

    public StringBuilder getUpBridge() {
        return upBridge;
    }

    public StringBuilder getDownBridge() {
        return downBridge;
    }

    public int getGameTrialCount() {
        return gameTrialCount;
    }

    public String getWinOrLose() {
        return winOrLose;
    }
}
