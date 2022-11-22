package bridge.game;

public class GameStatus {

    private final int ADJUST_COUNT_NUMBER = 1;


    private boolean end;
    private int tryCount;


    public GameStatus() {
        this.end = false;
    }

    public boolean isEnd() {
        return end;
    }

    public int getTryCount() {
        return tryCount + ADJUST_COUNT_NUMBER;
    }

    public void end() {
        this.end = true;
    }

    public void again() {
        this.tryCount++;
    }
}
