package bridge.Controller;

import bridge.Domain.BridgeMaker;
import bridge.Domain.BridgeNumberGenerator;
import bridge.Domain.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    OutputView outputView = new OutputView();
    List<String> bridge = new ArrayList<>();
    public void start() {
        int lengthOfBridge = gameStart();
    }

    public int gameStart() {
        outputView.printGameStart();
        outputView.printEmptyLine();
        int lengthOfBridge = InputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(lengthOfBridge);
        outputView.printEmptyLine();
        return lengthOfBridge;
    }
}
