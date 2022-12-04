package bridge.domain;

public class GameStatus {
    private final String gameHistory;
    private GameFlag flag;
    private int count;

    public GameStatus(GameUser gameUser) {
        this.flag = GameFlag.PLAYING;
        this.gameHistory = gameUser.toString();
    }

    public void setFlag(GameFlag flag) {
        this.flag = flag;
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
