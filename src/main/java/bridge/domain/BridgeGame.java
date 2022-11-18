package bridge.domain;

import static bridge.utils.Constants.RETRY;

public class BridgeGame {

    private final Player player;

    public BridgeGame(int bridgeSize, BridgeMaker bridgeMaker) {
        this.player = new Player(bridgeMaker.makeBridge(bridgeSize));
    }

    public boolean move(String spaceToMove) {
        return player.canMove(spaceToMove);
    }

    public boolean retry(String retryCommand) {
        if (retryCommand.equals(RETRY)) {
            player.retry();
            return true;
        }
        return false;
    }

    public boolean gameEnd() {
        return player.crossTheBridge();
    }

    public Player getPlayer() {
        return player;
    }
}
