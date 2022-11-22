package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeService {
    public Bridge initializeBridge() {
        return new Bridge(getLength(), new BridgeMaker(new BridgeRandomNumberGenerator()));
    }

    private int getLength() {
        while (true) {
            try {
                OutputView.messageLengthInput();
                return InputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
