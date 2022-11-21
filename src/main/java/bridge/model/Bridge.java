package bridge.model;

import bridge.controller.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.ValidationException;
import bridge.view.InputView;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
