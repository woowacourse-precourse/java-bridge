package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        int size = inputView.readBridgeSize();
    }
}
