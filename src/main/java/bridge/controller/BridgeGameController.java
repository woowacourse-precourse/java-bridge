package bridge.controller;

import bridge.constant.BridgePhrase;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import bridge.domain.service.BridgeGame;

import bridge.domain.resources.bridge.Bridge;
import bridge.domain.resources.bridge.BridgeSize;

import bridge.domain.resources.GameCommand;
import bridge.domain.resources.Move;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final boolean ONE_MORE_TRY = true;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void run() {
        outputView.print(BridgePhrase.START_GAME_PHRASE);
        BridgeMaker bridgeMaker = setBridgeMaker();
        BridgeSize bridgeSize = readBridgeSize();
        Bridge bridge = makeBridge(bridgeMaker, bridgeSize);
        gameProcess(bridge, bridgeSize);
        printFinalGameResult();
        printSuccessOrNot();
        printTotalAttempts();
    }

    private BridgeMaker setBridgeMaker() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeRandomNumberGenerator);
    }

    private BridgeSize readBridgeSize() {
        return inputView.readBridgeSize();
    }

    private Bridge makeBridge(final BridgeMaker bridgeMaker, final BridgeSize bridgeSize) {
        return new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()));
    }

    private void gameProcess(final Bridge bridge, final BridgeSize bridgeSize) {
        boolean button;
        do {
            boolean escape = moveUpOrDown(bridge, bridgeSize);
            button = retryOrQuit();
            if (escape && bridgeGame.isSuccess()) {
                break;
            }
        } while (bridgeGame.isRetry(button) == ONE_MORE_TRY);
    }

    private boolean moveUpOrDown(final Bridge bridge, final BridgeSize bridgeSize) {
        bridgeGame.incrementTotalAttempts();
        while (bridgeGame.isSuccess() && untilTheEnd(bridgeSize)) {
            move(bridge);
            printMap();
        }
        return !untilTheEnd(bridgeSize);
    }

    private boolean untilTheEnd(final BridgeSize bridgeSize) {
        return bridgeGame.getStepDistance() != bridgeSize.getSize();
    }

    private void move(Bridge bridge) {
        Move move = readMoving();
        bridgeGame.move(bridge, move);
    }

    private Move readMoving() {
        return inputView.readMoving();
    }

    private void printMap() {
        outputView.printMap(bridgeGame);
    }

    private boolean retryOrQuit() {
        if (!bridgeGame.isSuccess()) {
            GameCommand gameCommand = readGameCommand();
            return bridgeGame.retry(gameCommand);
        }
        return true;
    }

    private GameCommand readGameCommand() {
        return inputView.readGameCommand();
    }

    private void printFinalGameResult() {
        outputView.print(BridgePhrase.GAME_RESULT);
        outputView.printResult(bridgeGame);
    }

    private void printSuccessOrNot() {
        if (bridgeGame.isSuccess()) {
            outputView.print(BridgePhrase.GAME_SUCCESS);
        } else if (!bridgeGame.isSuccess()) {
            outputView.print(BridgePhrase.GAME_FAIL);
        }
    }

    private void printTotalAttempts() {
        outputView.print(BridgePhrase.GAME_TRY_COUNT, bridgeGame.totalAttempts());
    }

}

