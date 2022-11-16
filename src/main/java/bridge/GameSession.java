package bridge;

import java.util.List;

public class GameSession {

    private final List<String> bridge;
    private int trial;

    public GameSession(List<String> bridge) {
        this.bridge = bridge;
        this.trial = 0;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getTrial() {
        return trial;
    }

    public void setTrial(int trial) {
        this.trial = trial;
    }
}
