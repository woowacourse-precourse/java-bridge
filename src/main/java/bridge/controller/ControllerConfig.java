package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class ControllerConfig {
    protected InputView inputView = new InputView();
    protected OutputView outputView = new OutputView();
    protected BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    protected BridgeGame bridgeGame;
    protected List<String> bridge;

}
