package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    private void moveOneStep() {
        bridgeGame.move(InputView.readMoving());
        OutputView.printMap(bridgeGame);
    }

    private boolean askToRetry() {
        String gameCommand = InputView.readGameCommand();
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    public void playNewBridgeGame() {
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        while (!bridgeGame.isSuccess()) {
            moveOneStep();
            if (!bridgeGame.isCorrectChoice() && !askToRetry()) {
                break;
            }
        }
        OutputView.printResult(bridgeGame);
    }

}
