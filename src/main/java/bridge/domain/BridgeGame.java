package bridge.domain;

import static bridge.utils.Constants.RETRY;

public class BridgeGame {

    private final Bridge bridge;
    private final Player player = new Player();

    public BridgeGame(int bridgeSize, BridgeMaker bridgeMaker) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public boolean move(String spaceToMove) {
        return player.canMove(bridge, spaceToMove);
    }

    public boolean retry(String retryCommand) {
        if (retryCommand.equals(RETRY)) {
            player.retry();
            return true;
        }
        return false;
    }

    public boolean gameEnd(int bridgeSize) {
        return player.crossTheBridge(bridgeSize);
    }

    public Player getPlayer() {
        return player;
    }
}
