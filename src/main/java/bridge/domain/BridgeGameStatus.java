package bridge.domain;

public class BridgeGameStatus {
    private int position;
    private int tryCount = 1;
    private GameStatus gameStatus;

    public void initGame() {
        initGameStatus();
        initPosition();
    }
    private void initPosition() {
        position = 0;
    }

    private void initGameStatus() {
        gameStatus = GameStatus.PLAYING;
    }

    public int getPosition() {
        return position;
    }

    public void increasePosition() {
        position++;
    }

    public void success() {
        gameStatus = GameStatus.SUCCESS;
    }

    public void fail() {
        gameStatus = GameStatus.FAIL;
    }

    public void increaseTryCount() {
        tryCount++;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getTryCount() {
        return tryCount;
    }
}
