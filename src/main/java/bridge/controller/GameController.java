package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public GameController() {
        inputView = new InputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void start() {
        Bridge bridge = createNewBridge();
    }

    private Bridge createNewBridge() {
        while (true) {
            try {
                return new Bridge(generateBridge());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private List<String> generateBridge() {
        return bridgeMaker.makeBridge(requestBridgeLength());
    }

    private int requestBridgeLength() {
        return inputView.readBridgeSize();
    }

}
