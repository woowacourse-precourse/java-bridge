package bridge.service;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeService {
    private int getLength() {
        OutputView.messageLengthInput();
        return InputView.readBridgeSize();
    }
}
