package bridge;

import java.util.List;

import static bridge.Const.*;

public class BridgeGameHost {

    private List<String> bridge;
    private int playerIndex;
    private int numberOfRetry;
    private boolean playerAlive;

    public BridgeGameHost() {
        numberOfRetry = 0;
        playerIndex = -1;
        playerAlive = true;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String stepOfIndexInBridge(int index) {
        return bridge.get(index);
    }

    public String getResult() {
        String answer = FAIL;

        if ((playerIndex - 1) == bridge.size() && playerAlive) {
            answer = SUCCESS;
        }

        return answer;
    }

    public boolean getPlayerAlive() {
        return playerAlive;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public int getRetry() {
        return numberOfRetry;
    }

    public void movePlayer() {
        this.playerIndex++;
    }

    public void playerDie() {
        this.playerAlive = false;
    }

    public void retry() {
        this.playerIndex = -1;
        this.playerAlive = true;
        this.numberOfRetry++;
    }
}
