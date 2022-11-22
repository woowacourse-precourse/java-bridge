package bridge.model;


import bridge.BridgeRandomNumberGenerator;
import bridge.InputUtil;
import bridge.controller.InputController;

import java.util.ArrayList;
import java.util.List;

public class AllBridge {

    private List<String> bridge = new ArrayList<>();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    InputUtil inputUtil = new InputUtil();

    public AllBridge() {
        bridge = bridgeMaker.makeBridge(inputUtil.getBridgeSize());
    }

    public List<String> getBridge() {
        return bridge;
    }
}
