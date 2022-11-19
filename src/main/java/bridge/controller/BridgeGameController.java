package bridge.controller;

import java.util.List;

import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.domain.BridgeResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame(new Bridge(), new BridgeResult());
    }

    public void run() {
        outputView.startBridgeGame();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeGame.makeBridge(bridgeSize);
        System.out.println(bridge);
        do {
            //TODO: 전체 값 초기화
            moveTotalBlocks(bridgeSize);
        } while (bridgeGame.retry(inputView.readGameCommand()));
    }

    private void moveTotalBlocks(int bridgeSize) {
        int blockPosition = 0;
        moveByBlock(blockPosition, bridgeSize);
    }

    private void moveByBlock(int blockPosition, int bridgeSize) {
        while (blockPosition != bridgeSize) {
            String trial = bridgeGame.move(inputView.readMoving(), blockPosition);
            outputView.printMap(bridgeGame.getResult());
            blockPosition++;

            if (trial.equals("X")) {
                break;
            }
        }
    }
}
