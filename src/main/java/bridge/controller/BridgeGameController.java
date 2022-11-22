package bridge.controller;

import bridge.controller.request.MoveAtBridgeRequest;
import bridge.controller.request.MoveByBlockRequest;
import bridge.domain.result.BridgeResult;
import bridge.service.BridgeGame;

public class BridgeGameController {

    private static final String EMPTY_STRING = "";
    private static final String WRONG = "X";
    private static final int ZERO = 0;

    private final BridgeGame bridgeGame;
    private int trial;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame(new BridgeResult());
        this.trial = ZERO;
    }

    public int getTrial() {
        return this.trial;
    }

    public String getResultBridge() {
        return bridgeGame.getResultBridge();
    }

    public boolean getCompleteCrossing(int bridgeSize) {
        return bridgeGame.completeCrossing(bridgeSize);
    }

    public void moveAtBridge(MoveAtBridgeRequest moveAtBridgeRequest) {
        do {
            increaseTrial();
            bridgeGame.initialize();
            moveByBlock(moveAtBridgeRequest.getMoveByBlockRequest());

            if (bridgeGame.completeCrossing(moveAtBridgeRequest.getBridge().getSize())) {
                break;
            }
        } while (bridgeGame.retry(moveAtBridgeRequest.getGameCommand()));
    }

    private void moveByBlock(MoveByBlockRequest moveByBlockRequest) {
        String correctOrWrong = EMPTY_STRING;
        int blockPosition = ZERO;

        while (!correctOrWrong.equals(WRONG) && blockPosition != moveByBlockRequest.getBridge().getSize()) {
            correctOrWrong = bridgeGame.move(moveByBlockRequest.getBridge().getBlock(blockPosition),
                    moveByBlockRequest.getInputHandler().getBlockToMove());
            moveByBlockRequest.getOutputView().printMap(bridgeGame.getResultBridge());
            blockPosition++;
        }
    }

    private void increaseTrial() {
        trial++;
    }
}
