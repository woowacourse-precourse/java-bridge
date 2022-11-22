package bridge.controller;

import bridge.controller.request.MoveAtBridgeRequest;
import bridge.controller.request.MoveByBlockRequest;
import bridge.domain.result.BridgeResult;
import bridge.service.BridgeGame;

public class BridgeGameController {

    private final BridgeGame bridgeGame;
    private int trial;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame(new BridgeResult());
        this.trial = 0;
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
            moveByBlock(0, moveAtBridgeRequest.getMoveByBlockRequest());

            if (bridgeGame.completeCrossing(moveAtBridgeRequest.getBridge().getSize())) {
                break;
            }
        } while (bridgeGame.retry(moveAtBridgeRequest.getGameCommand()));
    }

    private void moveByBlock(int blockPosition, MoveByBlockRequest moveByBlockRequest) {
        while (blockPosition != moveByBlockRequest.getBridge().getSize()) {
            String trial = bridgeGame.move(moveByBlockRequest.toServiceDto(), blockPosition);
            moveByBlockRequest.getOutputView().printMap(bridgeGame.getResultBridge());
            blockPosition++;

            if (trial.equals("X")) {
                break;
            }
        }
    }

    private void increaseTrial() {
        trial++;
    }
}
