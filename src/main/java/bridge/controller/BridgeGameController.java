package bridge.controller;

import bridge.*;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.constant.ExceptionMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private final String END_GAME = "Q";
    private final String RETRY_GAME = "R";
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame;

    public void gameStart() {
        outputView.printStartMessage();
        initBridge();
        gamePlay();
        outputView.printResult(bridgeGame.getResultGame());
    }

    private void initBridge() {
        Bridge bridge = new Bridge(makeBridge());
        bridgeGame = new BridgeGame(bridge);
    }

    private List<String> makeBridge() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private void gamePlay() {
        boolean gameState = true;

        while (gameState) {
            gameMovement();
            gameState = isRetry();
        }
    }

    private void gameMovement() {
        while (!bridgeGame.isFinish()) {
            outputView.printMap(bridgeGame.move(inputView.readMoving()));
        }
    }

    private boolean isRetry() {
        if (bridgeGame.isSuccess()) {
            return false;
        }

        return askRetry();
    }

    private boolean askRetry() {
        String inputValue = inputView.readGameCommand();
        validate(inputValue);

        if (inputValue.equals(RETRY_GAME)) {
            bridgeGame.retry();
            return true;
        }

        return false;
    }

    private void validate(String inputValue) {
        if (!inputValue.equals(END_GAME) && !inputValue.equals(RETRY_GAME)) {
            ExceptionMessage.INPUT_WRONG_RETRY_ANSWER_MESSAGE.throwException();
        }
    }
}
