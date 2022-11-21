package model;


import bridge.BridgeRandomNumberGenerator;
import controller.InputController;
import view.InputView;

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
