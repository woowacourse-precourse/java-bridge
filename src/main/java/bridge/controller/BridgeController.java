package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.enums.ExceptionMessage;
import bridge.view.InputView;
import bridge.view.OutputView;
import domain.BridgeGame;

public class BridgeController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame;

    public void run() {
        outputView.outputGameStart();
        bridgeGame = createBridge();
        movesBridge();
        endGame();
    }

    private BridgeGame createBridge() {
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            return new BridgeGame(bridgeMaker.makeBridge(inputBridgeSize()));
        } catch (IllegalArgumentException e) {
            outputView.outputException(ExceptionMessage.ERROR_NOT_RANGE_SIZE.getErrorMessage());
            return createBridge();
        }
    }

    private int inputBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            outputView.outputException(ExceptionMessage.ERROR_NOT_NUMBER.getErrorMessage());
            return inputBridgeSize();
        }
    }

    private void movesBridge() {
        bridgeGame.initUserMove();
        do {
            move();
        } while (!bridgeGame.moreAsk() && bridgeGame.isSuccess());
        if (!bridgeGame.isSuccess()) {
            fail();
        }
    }

    private void move() {
        try {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserMove());
        } catch (IllegalArgumentException e) {
            outputView.outputException(ExceptionMessage.errorInputUpOrDown());
            move();
        }
    }

    private void fail() {
        try {
            if (bridgeGame.retry(inputView.readGameCommand())) {
                movesBridge();
            }
        } catch (IllegalArgumentException e) {
            outputView.outputException(ExceptionMessage.errorInputRetryOrQuit());
            fail();
        }
    }

    private void endGame() {
        outputView.printResultMap(bridgeGame.getBridge(), bridgeGame.getUserMove());
        outputView.printResult(bridgeGame.isSuccess(), bridgeGame.getTryTimes());
    }

}
