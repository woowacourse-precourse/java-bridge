package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
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
    }

    private BridgeGame createBridge() {
        try {
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            outputView.outputEnterBridgeSize();
            return new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        } catch (IllegalArgumentException e) {
            outputView.outputException(ExceptionMessage.ERROR_NOT_RANGE_SIZE.getErrorMessage());
            return createBridge();
        }
    }

    private void movesBridge() {
        bridgeGame.initUserMove();
        do {
            move();
        } while (!bridgeGame.moreAsk() && bridgeGame.gameResult());
        if (!bridgeGame.gameResult()) {
            fail();
        } else {
            endGame();
        }
    }

    private void move() {
        try {
            outputView.outputChooseMovePosition();
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserMove());
        } catch (IllegalArgumentException e) {
            outputView.outputException(ExceptionMessage.errorInputUpOrDown());
            move();
        }
    }

    private void fail() {
        try {
            outputView.outputChooseRestartOrQuit();
            if (bridgeGame.retry(inputView.readGameCommand())) {
                movesBridge();
            } else {
                endGame();
            }
        } catch (IllegalArgumentException e) {
            outputView.outputException(ExceptionMessage.errorInputRetryOrQuit());
            fail();
        }
    }

    private void endGame() {
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getUserMove(), bridgeGame.gameResult(), bridgeGame.getTryTimes());
    }

}
