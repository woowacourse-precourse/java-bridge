package bridge.domain;

public class GameStatus {
    private final String gameHistory;
    private GameFlag flag = GameFlag.PLAYING;
    private int count;

    public GameStatus(GameUser gameUser) {
        this.gameHistory = gameUser.toString();
    }

    public void setFlag(GameUser gameUser, Bridge answerBridge) {
        if (gameUser.isGetOutFrom(answerBridge)) {
            flag = GameFlag.FAIL;
            return;
        }
        flag = GameFlag.CLEAR;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return flag.getMessage();
    }

    public int getCount() {
        return count;
    }

    public String getGameHistory() {
        return gameHistory;
    }

    public boolean isPlaying() {
        return flag.isPlaying();
    }

    public boolean isClear() {
        return flag.isClear();
    }

    public boolean isFail() {
        return flag.isFail();
    }

}
