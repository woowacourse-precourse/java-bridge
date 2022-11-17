package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> bridge;
    private final List<String> results = new ArrayList<>();
    private int playCount;

    public Player(List<String> bridge) {
        this.bridge = bridge;
        this.playCount = 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getResults() {
        return results;
    }

    public int getPlayCount() {
        return playCount;
    }

    //== 비즈니스 로직 ==//
    public void addResult(String result) {
        results.add(result);
    }

    public boolean isGameEnd() {
        return results.size() == bridge.size();
    }

    public void resetResults() {
        results.clear();
        playCount++;
    }
}
