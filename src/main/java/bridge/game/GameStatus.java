package bridge.game;

public class GameStatus {
    private boolean end;
    private int tryCount;


    public GameStatus() {
        this.end = false;
    }

    public boolean isEnd() {
        return end;
    }

    public int getTryCount() {
        return tryCount + 1;
    }

    public void end() {
        this.end = true;
    }

    public void again() {
        this.tryCount++;
    }
}
