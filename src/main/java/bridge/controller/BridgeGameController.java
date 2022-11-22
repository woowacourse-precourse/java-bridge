package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

import static bridge.util.constants.GameCommand.RETRY;

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
            outputView.printResult(bridgeGame);
        } catch(IllegalStateException exception) {
            outputView.printError(exception);
        }
    }

    private BridgeGame generateGame() {
        Bridge bridge = generateBridge();
        Player player = new Player();
        return new BridgeGame(bridge, player);
    }

    private Bridge generateBridge() {
        int bridgeSize = getValidBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> movableSpaces = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(movableSpaces);
    }

    private int getValidBridgeSize() {
        while (true) {
            try {
                outputView.printBridgeSizeInputRequest();
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception);
            }
        }
    }

    private void playGame(BridgeGame bridgeGame) {
        while (!bridgeGame.isFinished()) {
            crossBridge(bridgeGame);
            outputView.printMap(bridgeGame);
            checkFailed(bridgeGame);
        }
    }

    private void crossBridge(BridgeGame bridgeGame) {
        String spaceToMove = getValidSpaceToMove();
        bridgeGame.move(spaceToMove);
    }

    private String getValidSpaceToMove() {
        while (true) {
            try {
                outputView.printMovingSpaceInputRequest();
                return inputView.readMoving();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception);
            }
        }
    }

    private void checkFailed(BridgeGame bridgeGame) {
        if (bridgeGame.isFailed()) {
            retryOrFinish(bridgeGame);
        }
    }

    private void retryOrFinish(BridgeGame bridgeGame) {
        if (getValidGameCommandInput().equals(RETRY.command())) {
            bridgeGame.retry();
        }
    }

    private String getValidGameCommandInput() {
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
