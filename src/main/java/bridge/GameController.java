package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputview = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    GameController() {
        run();
    }

    private void run() {
        int bridgeSize = init();
    }

    private int init() {
        outputview.printStart();
        return inputView.readBridgeSize();
    }
}
