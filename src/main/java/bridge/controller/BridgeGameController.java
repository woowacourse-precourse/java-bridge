package bridge.controller;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        BridgeGenerator bridgeGenerator = new BridgeGenerator(bridgeSize);
        Bridge bridge = new Bridge(bridgeGenerator.generate());

        BridgeGame bridgeGame = new BridgeGame(bridge);

        while (true) {
            BridgeGameResult bridgeGameResult = new BridgeGameResult();
            for (int movingIndex = 0; movingIndex < bridgeSize; movingIndex++) {
                String moving = inputView.readMoving();
                String result = bridgeGame.move(moving, movingIndex);
                bridgeGameResult.putResult(moving, result);
            }
        }
    }
}
