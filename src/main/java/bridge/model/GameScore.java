package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class GameScore {
    private GameResult result;
    private int count;
    private List<String> bridge;

    public GameScore() {
        this.result = GameResult.FAILURE;
        this.count = 0;
        this.bridge = new ArrayList<>();
    }

    public GameResult getResult() {
        return result;
    }

    public int getCount() {
        return count;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void setGameScore(boolean isSuccess, int count, List<String> bridge) {
        this.result = GameResult.get(isSuccess);
        this.count = count;
        this.bridge = bridge;
    }
}


