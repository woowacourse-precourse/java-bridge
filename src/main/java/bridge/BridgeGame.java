package bridge;

import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private int playerLocation = -1;
    private int trialCount = 1;

    public BridgeGame(List<String> bridge) {;
        this.bridge = bridge;
    }

    public void move(boolean isMoveAvailable) {
        if (isMoveAvailable) {
            this.playerLocation++;
        }
    }

    public void retry(boolean doesPlayerWantRetrial) {
        if (doesPlayerWantRetrial) {
            this.trialCount++;
        }
    }

    public Boolean checkMoveIsAvailable (String playerMoving) {
        if (bridge.get(playerLocation + 1).equals(playerMoving)) {
            return true;
        }
        return false;
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
