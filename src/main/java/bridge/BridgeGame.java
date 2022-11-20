package bridge;

import constants.BridgeConstants;

public class BridgeGame {

    private final BridgeState bridgeState;
    private final BridgeFigureBuilder bridgeFigureBuilder;
    private int gameTryCount;

    public BridgeGame() {
        this.bridgeState = new BridgeState();
        this.bridgeFigureBuilder = new BridgeFigureBuilder(bridgeState);
        this.gameTryCount = 1;
    }

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

    public BridgeFigureBuilder getBridgeFigureBuilder() {
        return bridgeFigureBuilder;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }
}
