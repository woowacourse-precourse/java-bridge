package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.ValidationException;
import bridge.view.InputView;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(getBridgeSize());
    }

    private int getBridgeSize() {
        ValidationException validationException = new ValidationException();
        InputView inputView = new InputView(validationException);

        return inputView.readBridgeSize();
    }

    public List<String> getBridge() {
        return bridge;
    }
}
