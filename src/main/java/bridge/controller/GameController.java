package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            outputView.startMsg();
            List<String> bridge = makeBridge();
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
        }
    }

    public List<String> makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}


