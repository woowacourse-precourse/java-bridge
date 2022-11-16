package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;
import java.util.List;

public class BridgeController {

    OutputView output;
    InputView input;
    BridgeMaker bridgeMaker;

    public BridgeController() {
        output = new OutputView();
        input = new InputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> startAndGetAnswerBridge() {
        output.printStart();

        try {
            return getAnswerBridge();
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getAnswerBridge();
        }
    }

    private List<String> getAnswerBridge() {
        output.printGetBridgeSize();
        int bridgeSize = input.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
