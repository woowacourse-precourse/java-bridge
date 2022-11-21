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
    private boolean button;
    private boolean escape;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        BridgeMaker bridgeMaker = setBridgeMaker();
        BridgeSize bridgeSize = readBridgeSize();
        Bridge bridge = makeBridge(bridgeMaker, bridgeSize);
        BridgeGame bridgeGame = new BridgeGame();
        gameProcess(bridgeSize, bridge, bridgeGame);
        printFinalGameResult(bridgeGame);
        printSuccessOrNot(bridgeGame);
        printTotalAttempts(bridgeGame);
    }

    private BridgeMaker setBridgeMaker() {
        outputView.print(BridgePhrase.START_GAME_PHRASE);
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeRandomNumberGenerator);
    }

    private BridgeSize readBridgeSize() {
        return inputView.readBridgeSize();
    }

    private Bridge makeBridge(final BridgeMaker bridgeMaker, final BridgeSize bridgeSize) {
        return new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()));
    }

    private void gameProcess(final BridgeSize bridgeSize, final Bridge bridge, final BridgeGame bridgeGame) {
        do {
            escape = moveUpOrDown(bridgeGame, bridge, bridgeSize);
            button = retryOrQuit(bridgeGame);
            if (escape && bridgeGame.checkFlag()) {
                break;
            }
            bridgeGame.isRetry(button);
        } while (button == ONE_MORE_TRY);
    }

    private boolean moveUpOrDown(final BridgeGame bridgeGame, final Bridge bridge, final BridgeSize bridgeSize) {
        bridgeGame.incrementTotalAttempts();
        while (bridgeGame.checkFlag() && untilTheEnd(bridgeGame, bridgeSize)) {
            move(bridgeGame, bridge);
            printMap(bridgeGame);
        }
        return !untilTheEnd(bridgeGame, bridgeSize);
    }

    private boolean untilTheEnd(final BridgeGame bridgeGame, final BridgeSize bridgeSize) {
        return bridgeGame.getStepDistance() != bridgeSize.getSize();
    }

    private void move(final BridgeGame bridgeGame, final Bridge bridge) {
        Move move = readMoving();
        bridgeGame.move(bridge, move);
    }

    private void printMap(final BridgeGame bridgeGame) {
        outputView.printMap(bridgeGame);
    }

    private Move readMoving() {
        return inputView.readMoving();
    }

    private boolean retryOrQuit(final BridgeGame bridgeGame) {
        if (!bridgeGame.checkFlag()) {
            GameCommand gameCommand = readGameCommand();
            return bridgeGame.retry(gameCommand);
        }
        return true;
    }

    private GameCommand readGameCommand() {
        return inputView.readGameCommand();
    }

    private void printFinalGameResult(final BridgeGame bridgeGame) {
        outputView.print(BridgePhrase.GAME_RESULT);
        outputView.printResult(bridgeGame);
    }

    private void printSuccessOrNot(final BridgeGame bridgeGame) {
        if (bridgeGame.checkFlag()) {
            outputView.print(BridgePhrase.GAME_SUCCESS);
        } else if (!bridgeGame.checkFlag()) {
            outputView.print(BridgePhrase.GAME_FAIL);
        }
    }

    private void printTotalAttempts(final BridgeGame bridgeGame) {
        outputView.print(BridgePhrase.GAME_TRY_COUNT, bridgeGame.totalAttempts());
    }

}

