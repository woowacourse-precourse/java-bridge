package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private InputView inputView;
    private OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            BridgeGame bridgeGame = new BridgeGame(bridgeSize);

            while (true) {
                String movement = inputView.readMoving();
                boolean isPass = bridgeGame.move(movement);

                if (!isPass) {
                    String command = inputView.readGameCommand();
                    if (!bridgeGame.retry(command)) {
                        outputView.printResult();
                        return;
                    }
                }
                if (bridgeGame.checkSuccess()) {
                    outputView.printResult();
                    return;
                }
            }
        } catch (IllegalArgumentException e) {

        }
    }
}
