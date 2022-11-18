package bridge;

public class GameStatus {
    private final String gameHistory;
    private GameFlag flag = GameFlag.PLAYING;

    public GameStatus(GameUser gameUser) {
        this.gameHistory = gameUser.toString();
    }

    public void setFlag(GameUser gameUser, Bridge answerBridge) {
        if (gameUser.hasDifferentBridge(answerBridge)) {
            flag = GameFlag.FAIL;
            return;
        }
        flag = GameFlag.CLEAR;
    }

    public GameFlag getFlag() {
        return flag;
    }

    public String getGameHistory() {
        return gameHistory;
    }
}
