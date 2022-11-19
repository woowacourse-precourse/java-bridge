package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.PassingSpace;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public BridgeGame createBridgeGame(Bridge bridge) {
        PassingSpace passingSpace = new PassingSpace();
        return new BridgeGame(bridge, passingSpace);
    }
}
