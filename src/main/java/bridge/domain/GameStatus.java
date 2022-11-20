package bridge.domain;

public class GameStatus {
    private final String gameHistory;
    private GameFlag flag = GameFlag.PLAYING;

    public GameStatus(GameUser gameUser) {
        this.gameHistory = gameUser.toString();
    }

    public void setFlag(GameUser gameUser, Bridge answerBridge) {
        if (gameUser.hasBridgeDifferentFrom(answerBridge)) {
            flag = GameFlag.FAIL;
            return;
        }
        flag = GameFlag.CLEAR;
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

    public String getMessage() {
        return flag.getMessage();
    }

    public String getGameHistory() {
        return gameHistory;
    }
}
