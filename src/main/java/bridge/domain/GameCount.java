package bridge.domain;

public class GameCount {
    private int count;

    public GameCount() {
        this.count = 0;
    }

    public void GameStart() {
        this.count++;
    }

    public int getTryGameCount() {
        return count;
    }
}
