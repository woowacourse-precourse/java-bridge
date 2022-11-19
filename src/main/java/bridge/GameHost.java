package bridge;

import java.util.List;

import static bridge.Const.FAIL;
import static bridge.Const.SUCCESS;

public class GameHost {

    private List<String> bridge;
    private int playerIndex;
    private int numberOfRetry;
    private boolean playerAlive;

    public GameHost() {
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

    public boolean getPlayerAlive() {
        return playerAlive;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public int getRetry() {
        return numberOfRetry;
    }

    public String isGameSuccess() {
        String answer = FAIL;

        if ((playerIndex - 1) == bridge.size()) {
            answer = SUCCESS;
        }

        return answer;
    }
}
