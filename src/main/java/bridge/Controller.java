package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        outputView.printStartGame();
    }
}
