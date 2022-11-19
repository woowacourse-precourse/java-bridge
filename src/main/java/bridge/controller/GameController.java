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

    public void runRound(BridgeGame bridgeGame) {
        String moving;
        do {
            moving = selectMoving();
            bridgeGame.move(moving);
            outputView.printMap(bridgeGame.drawPassingSpace());
        } while (continueRound(bridgeGame, moving));
    }

    private boolean continueRound(BridgeGame bridgeGame, String moving) {
        return bridgeGame.isRightSpace() && !bridgeGame.isSuccessCrossingBridge();
    }

    private String selectMoving() {
        try {
            outputView.printSelectUpOrDownInput();
            String readMoving = inputView.readMoving();
            return readMoving;
        } catch (IllegalArgumentException illegalArgumentException) {
            return selectMoving();
        }
    }
}
