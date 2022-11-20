package bridge;

import constants.BridgeConstants;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeState bridgeState = new BridgeState();
    private int gameTryCount = 1;

    public boolean move(Bridge bridge, String moving, int round) {
        String resultOfMoving = bridge.isCorrectMoving(moving, round);
        bridgeState.updateStateOfBridge(moving, resultOfMoving);

        if (resultOfMoving.equals(BridgeConstants.WRONG_ANSWER)) {
            return false;
        }
        return true;
    }

    public void retry() {
        gameTryCount++;
        bridgeState.clearAllBridgeState();
    }

    public Bridge generateBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public BridgeState getStateOfBridge() {
        return bridgeState;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }
}
