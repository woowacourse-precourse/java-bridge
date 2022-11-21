package bridge.service;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeService {
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
