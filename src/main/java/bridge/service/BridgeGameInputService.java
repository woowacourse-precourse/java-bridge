package bridge.service;

import bridge.constant.enumtype.UIMessage;
import bridge.view.InputView;

public class BridgeGameInputService {
    private InputView bridgeGameInputView;

    public BridgeGameInputService() {
        this.bridgeGameInputView = new InputView();
    }

    public Integer readBridgeSize() {
        try {
            return bridgeGameInputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
    }
}
