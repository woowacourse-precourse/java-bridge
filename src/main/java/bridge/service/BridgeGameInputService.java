package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.enumtype.UIMessage;
import bridge.dto.bridge.Bridge;
import bridge.view.InputView;
import java.util.List;

public class BridgeGameInputService {
    private InputView bridgeGameInputView;
    private Bridge bridge;

    public BridgeGameInputService() {
        this.bridgeGameInputView = new InputView();
    }

    private Integer readBridgeSize() {
        try {
            return bridgeGameInputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
    }

    public void createBridge() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(readBridgeSize());
        saveBridge(bridge);
    }

    private void saveBridge(List<String> bridge) {
        this.bridge = new Bridge(bridge);
    }

    public String readMoving() {
        try {
            return bridgeGameInputView.readMoving();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMoving();
        }
    }
}
