package bridge;

public class GameStatus {
    private String gameHistory;
    private int flag = -1;

    public GameStatus(GameUser gameUser) {
        this.gameHistory = gameUser.toString();
    }

    public void setFlag(GameUser gameUser, Bridge answerBridge) {
        if (gameUser.hasSameBridge(answerBridge)) {
            flag = 0;
            return;
        }
        flag = 1;
    }

    public int getFlag() {
        return flag;
    }

    public String getGameHistory() {
        return gameHistory;
    }
}
