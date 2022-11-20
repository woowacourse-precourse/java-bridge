package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void run() {
        init();
    }

    private void init() {
        outputView.printStartingGame();
        outputView.printAskingBridgeLength();
        while (true) {
            try {
                bridgeGame = new BridgeGame(inputView.readBridgeSize());
                System.out.println();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
