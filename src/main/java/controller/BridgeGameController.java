package controller;

import bridge.*;
import view.InputView;
import view.OutputView;

public class BridgeGameController {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeGameController(BridgeNumberGenerator numberGenerator) {
        bridgeNumberGenerator = numberGenerator;
    }

    public void gameStart() {
        GameStatus gameStatus = new GameStatus(false, false);
        BridgeGame bridgeGame = getBridgeGame(gameStatus);
        while (!gameStatus.isClear()) {
            moveAndCompare(bridgeGame);
            OutputView.printMap(bridgeGame);
            if (gameStatus.isFailure()) {
                restart(bridgeGame);
            }
        }
        OutputView.printResult(bridgeGame, gameStatus);
    }

    private void moveAndCompare(BridgeGame bridgeGame) {
        move(bridgeGame);
        bridgeGame.comparedBridge();
    }

    private BridgeGame getBridgeGame(GameStatus gameStatus) {
        Bridge bridge = getBridge();
        return new BridgeGame(bridge, gameStatus);
    }

    private void move(BridgeGame bridgeGame) {
        while (true) {
            try {
                String movePosition = InputView.readMoving();
                bridgeGame.move(movePosition);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE + exception.getMessage());
            }
        }
    }

    private void restart(BridgeGame bridgeGame) {
        while (true) {
            try {
                String restartCommand = InputView.readGameCommand();
                bridgeGame.retry(restartCommand);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE + exception.getMessage());
            }
        }
    }

    private Bridge getBridge() {
        while (true) {
            try {
                return createSpecificSizeBridge();
            } catch (NumberFormatException exception) {
                System.out.println(ERROR_MESSAGE + "오직 숫자로만 이루어져 있어야 합니다.");
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE + exception.getMessage());
            }
        }
    }

    private Bridge createSpecificSizeBridge() {
        int bridgeSize = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}
