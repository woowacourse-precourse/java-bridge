package bridge.controller;

import java.util.List;

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
        this.bridgeGame = new BridgeGame(new BridgeResult());
        this.trial = 0;
    }

    public void run() {
        outputView.startBridgeGame();
        Bridge bridge = inputView.readBridgeSize();

        moveTotalBlocks(bridge.getBridge());

        outputView.printResult(bridgeGame.getResultBridge(),
                bridgeGame.completeCrossing(bridge.getSize()),
                this.trial);
    }

    private void moveTotalBlocks(List<String> bridge) {
        do {
            increaseTrial();
            bridgeGame.initialize();
            moveByBlock(START_BLOCK_POSITION, bridge);

            if (bridgeGame.completeCrossing(bridge.size())) {
                break;
            }
        } while (bridgeGame.retry(inputView.readGameCommand()));
    }

    private void moveByBlock(int blockPosition, List<String> bridge) {
        while (blockPosition != bridge.size()) {
            String trial = bridgeGame.move(inputView.readMoving(), blockPosition, bridge);
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
