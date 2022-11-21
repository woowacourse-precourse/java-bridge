package bridge.controller;

import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.domain.BridgeResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private static final int START_BLOCK_POSITION = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private int trial;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame(new Bridge(), new BridgeResult());
        this.trial = 0;
    }

    public void run() {
        outputView.startBridgeGame();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.makeBridge(bridgeSize);
        moveTotalBlocks(bridgeSize);
        outputView.printResult(bridgeGame.getResultBridge(), bridgeGame.completeCrossing(bridgeSize), this.trial);
    }

    private void moveTotalBlocks(int bridgeSize) {
        do {
            increaseTrial();
            bridgeGame.initialize();
            moveByBlock(START_BLOCK_POSITION, bridgeSize);

            if (bridgeGame.completeCrossing(bridgeSize)) {
                break;
            }
        } while (bridgeGame.retry(inputView.readGameCommand()));
    }

    private void moveByBlock(int blockPosition, int bridgeSize) {
        while (blockPosition != bridgeSize) {
            String trial = bridgeGame.move(inputView.readMoving(), blockPosition, bridgeSize);
            outputView.printMap(bridgeGame.getResultBridge());
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
