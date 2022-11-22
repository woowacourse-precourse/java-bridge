package bridge;

import bridge.identifiers.Direction;
import bridge.paths.Bridge;
import bridge.paths.PlayerPath;

public class BridgeGame {

    private Bridge bridge;
    private PlayerPath playerPath;

    private boolean isAlive;
    private int countAttempt;

    public BridgeGame() {
    }

    public void initComponents(BridgeNumberGenerator bridgeNumberGenerator, int bridgeLength) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeLength));
        playerPath = new PlayerPath();
        isAlive = true;
        countAttempt = 1;
    }

    public void move(Direction direction) {
        playerPath.saveDirection(direction);
        if (!bridge.canBeSteppedBy(playerPath)) {
            playerPath.die();
        }
    }

    public void retry() {
        playerPath = new PlayerPath();
        ++countAttempt;
    }

    public PlayerPath getPlayerPath() {
        return playerPath;
    }

    public boolean isSuccess() {
        return bridge.isCompletedWith(playerPath);
    }

    public boolean isGameOver() {
        if (!playerPath.getIsAlive()) {
            return true;
        }
        return false;
    }

    public void setDead() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getCountAttempt() {
        return countAttempt;
    }
}
