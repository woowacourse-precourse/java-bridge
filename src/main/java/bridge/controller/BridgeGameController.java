package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private static final String RETRY = "R";

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printGameStart();
        try {
            BridgeGame bridgeGame = generateGame();
            playGame(bridgeGame);
            outputView.printResult(bridgeGame);
        } catch(IllegalStateException exception) {
            outputView.printError(exception);
        }
    }

    private BridgeGame generateGame() {
        while (true) {
            try {
                return new BridgeGame(generateBridge(), new Player());
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception);
            }
        }
    }

    private Bridge generateBridge() {
        int bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> movableSpaces = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(movableSpaces);
    }

    private int getBridgeSize() {
        outputView.printBridgeSizeInputRequest();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }

    private void playGame(BridgeGame bridgeGame) {
        while (true) {
            try {
                crossBridgeUntilFinish(bridgeGame);
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception);
            }
        }
    }

    private void crossBridgeUntilFinish(BridgeGame bridgeGame) {
        while (!bridgeGame.isFinished()) {
            crossBridge(bridgeGame);
            outputView.printMap(bridgeGame);
            checkFailed(bridgeGame);
        }
    }

    private void crossBridge(BridgeGame bridgeGame) {
        String spaceToMove = getSpaceToMove();
        bridgeGame.move(spaceToMove);
    }

    private String getSpaceToMove() {
        outputView.printMovingInputRequest();
        String spaceToMove = inputView.readMoving();
        return spaceToMove;
    }

    private void checkFailed(BridgeGame bridgeGame) {
        if (bridgeGame.isFailed()) {
            retryOrFinish(bridgeGame);
        }
    }

    private void retryOrFinish(BridgeGame bridgeGame) {
        if (getGameCommandInput().equals(RETRY)) {
            bridgeGame.retry();
        }
    }

    private String getGameCommandInput() {
        while (true) {
            try {
                outputView.printGameCommandInputRequest();
                return inputView.readGameCommand();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception);
            }
        }
    }
}
