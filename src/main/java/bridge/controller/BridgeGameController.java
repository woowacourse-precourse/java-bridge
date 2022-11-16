package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final OutputView outputView = new OutputView();

    private final InputView inputView = new InputView();

    public void startGame() {
        outputView.printGameStart();
        int bridgeSize = getBridgeSize();
    }

}
