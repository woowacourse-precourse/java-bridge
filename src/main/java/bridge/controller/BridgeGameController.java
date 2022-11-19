package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
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

    private List<String> generateBridge() {
        int bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private int getBridgeSize() {
        outputView.printBridgeSizeInputRequest();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }

    private void playGame(BridgeGame bridgeGame) {
        try {
            crossBridgeUntilFinish(bridgeGame);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception);
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
        outputView.printMovingInputRequest();
        String spaceToMove = inputView.readMoving();
        bridgeGame.move(spaceToMove);
    }

    private void checkFailed(BridgeGame bridgeGame) {
        if (bridgeGame.isFailed()) {
            askRetryOrFinish(bridgeGame);
        }
    }

    private void askRetryOrFinish(BridgeGame bridgeGame) {
        outputView.printGameCommandInputRequest();
        String gameCommand = inputView.readGameCommand();
    }
}
