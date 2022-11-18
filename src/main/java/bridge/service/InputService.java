package bridge.service;

import bridge.view.InputView;
import bridge.view.OutputView;

public class InputService {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void printGameStart() {
        outputView.printGameStart();
    }

    public int requestBridgeSize() {
        outputView.printRequestBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }
}