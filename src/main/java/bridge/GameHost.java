package bridge;

import java.util.List;

public class GameHost {

    private List<String> bridge;
    private int playerIndex;
    private boolean playerAlive;

    public GameHost() {
        playerIndex = -1;
        playerAlive = true;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String stepOfIndexInBridge(int index) {
        return bridge.get(index);
    }

    public boolean isPlayerAlive() {
        return playerAlive;
    }

    public int whereIsPlayer() {
        return playerIndex;
    }
}
