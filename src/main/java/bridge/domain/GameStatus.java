package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {

    private static final String FAILURE = "실패";

    public int tryCount;
    public String gameResult;
    public List<String> topBridge;
    public List<String> bottomBridge;

    public GameStatus() {
        this.tryCount = 1;
        this.gameResult = FAILURE;
        this.topBridge = new ArrayList<>();
        this.bottomBridge = new ArrayList<>();
    }

    public void resetGameStatus() {
        this.tryCount += 1;
        this.topBridge = new ArrayList<>();
        this.bottomBridge = new ArrayList<>();
    }
}
