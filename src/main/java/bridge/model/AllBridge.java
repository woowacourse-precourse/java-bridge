package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.InputController;

import java.util.ArrayList;
import java.util.List;

public class AllBridge {
    private List<String> bridge = new ArrayList<>();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    InputController inputController = new InputController();

    public AllBridge() {
        bridge = bridgeMaker.makeBridge(inputController.getBridgeSize());
    }

    public List<String> getBridge() {
        return bridge;
    }
}
