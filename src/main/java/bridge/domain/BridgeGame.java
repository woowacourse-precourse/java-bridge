package bridge.domain;

import static bridge.utils.Constants.RETRY;

public class BridgeGame {

    private final Bridge bridge;
    private final PlayResult playResult = new PlayResult();

    public BridgeGame(int bridgeSize, BridgeMaker bridgeMaker) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public boolean move(int position, String spaceToMove) {
        boolean canMove = bridge.canMove(position, spaceToMove);
        playResult.updateResult(spaceToMove, canMove);
        return canMove;
    }

    public boolean retry(String retryCommand) {
        if (retryCommand.equals(RETRY)) {
            playResult.retry();
            return true;
        }
        return false;
    }

    public PlayResult getPlayResult() {
        return playResult;
    }
}
