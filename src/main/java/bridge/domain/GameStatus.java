package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {

    public int tryCount;
    public String gameResult;
    public List<String> topBridge;
    public List<String> bottomBridge;

    public GameStatus() {
        this.tryCount = 1;
        this.gameResult = "실패";
        this.topBridge = new ArrayList<>();
        this.bottomBridge = new ArrayList<>();
    }

    public void resetGameStatus() {
        this.topBridge = new ArrayList<>();
        this.bottomBridge = new ArrayList<>();
    }
}
