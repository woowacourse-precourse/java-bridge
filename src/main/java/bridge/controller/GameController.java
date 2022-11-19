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

    public void playGame(BridgeGame bridgeGame) {
        // TODO: 게임을 플레이하는 기능
    }

    public String selectMoving() {
        try {
            outputView.printSelectUpOrDownInput();
            String readMoving = inputView.readMoving();
            return readMoving;
        } catch (IllegalArgumentException illegalArgumentException) {
            return selectMoving();
        }
    }
}
