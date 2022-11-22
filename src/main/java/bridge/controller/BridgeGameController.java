package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.data.Command;
import bridge.data.Game;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        outputView.printStartMessage();
        int bridgeSize = getBridgeSize();
        outputView.printMessage();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        crossBridge(bridgeGame);
        outputView.printResult(bridgeGame.getMovingMap(), bridgeGame.allPass(), bridgeGame.getTryCount());
    }

    private int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private void crossBridge(BridgeGame bridgeGame) {
        boolean keepGoing;
        do {
            keepGoing = moveAndCheckMovingSuccess(bridgeGame);
            outputView.printMap(bridgeGame.getMovingMap());
            if (!keepGoing && retryGame(bridgeGame)) {
                keepGoing = true;
            }
        } while (keepGoing && !bridgeGame.allPass());
    }

    private boolean moveAndCheckMovingSuccess(BridgeGame bridgeGame) {
        outputView.printMessage(Game.MOVING_CHOICE_MESSAGE.getMessage());
        String moving = getMovingCommand();
        return bridgeGame.move(moving);
    }

    private String getMovingCommand() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private boolean retryGame(BridgeGame bridgeGame) {
        outputView.printMessage(Game.RETRY_MESSAGE.getMessage());
        if (getGameCommand().equals(Command.RETRY.getLabel())) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private String getGameCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
}
