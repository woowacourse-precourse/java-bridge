package bridge;

public class GameStatus {
    private String gameHistory;
    private int flag = -1;

    public GameStatus(GameUser gameUser) {
        this.gameHistory = gameUser.toString();
    }

    public void setFlag(GameUser gameUser, Bridge answerBridge) {
        if (gameUser.hasDifferentBridge(answerBridge)) {
            flag = 1;
            return;
            // 0은 답을 맞춤을 의미함.
            // -1은 맞추지도 않고 틀리지도 않은 상태.
            // 1은 틀린 상태.
        }
        flag = 0;
    }

    public int getFlag() {
        return flag;
    }

    public String getGameHistory() {
        return gameHistory;
    }
}
