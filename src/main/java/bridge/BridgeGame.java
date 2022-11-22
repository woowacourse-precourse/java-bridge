package bridge;

import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private int playerLocation = -1;
    private int nextLocation = playerLocation + 1;
    private int trialCount = 1;


    public BridgeGame(List<String> bridge) {;
        this.bridge = bridge;
    }

    public void move(boolean isMoveAvailable) {
        this.playerLocation++;
    }

    public void retry(boolean doesPlayerWantRetrial) {
        this.trialCount++;
    }

    public Boolean checkMoveIsAvailable (String playerMoving) {
        if (bridge.get(nextLocation).equals(playerMoving)) {
            return true;
        }
        if (!bridge.get(nextLocation).equals(playerMoving)) {
            return false;
        }
        return null;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public int getPlayerLocation() {
        return this.playerLocation;
    }

    public int getTrialCount() {
        return this.trialCount;
    }
}
