package bridge.domain;

import bridge.view.input.InputView;
import bridge.view.output.OutputView;

import static bridge.domain.Constants.*;

public class BridgeGameManager {

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeState bridgeState = new BridgeState();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private int bridgeSize = BRIDGE_SIZE_INIT;

    public void start() {
        outputView.printGameStartNotification();
        BridgeGame bridgeGame = makeBridgeGame();
        mainProgress(bridgeGame);
        printGameResult(bridgeGame);
    }

    private BridgeGame makeBridgeGame() {
        return new BridgeGame(bridgeMaker.makeBridge(readBridgeSize()), bridgeState);
    }

    private int readBridgeSize() {
        while (true) {
            outputView.printInputBridgeSizeNotification();
            try {
                bridgeSize = inputView.readBridgeSize();
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void mainProgress(BridgeGame bridgeGame) {
        initBrigeSize(bridgeGame);
        while (bridgeSize --> BRIDGE_SIZE_INIT) {
            moveProgress(bridgeGame);
            outputView.printMap(bridgeState);
            if (!bridgeGame.isWon() && !isRetry(bridgeGame)) {
                break;
            }
        }
    }

    private void initBrigeSize(BridgeGame bridgeGame) {
        bridgeSize = bridgeGame.getBridgeSize();
    }

    private void moveProgress(BridgeGame bridgeGame) {
        bridgeGame.move(readMoving());
    }

    private String readMoving() {
        while (true) {
            outputView.printInputArrow();
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private boolean isRetry(BridgeGame bridgeGame) {
        if (bridgeGame.retry(readGameCommand())) {
            initBrigeSize(bridgeGame);
            return true;
        }
        return false;
    }

    private String readGameCommand() {
        while (true) {
            outputView.printInputRetryOrNot();
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printGameResult(BridgeGame bridgeGame) {
        outputView.printResult(bridgeState);
        outputView.printGameResult(bridgeGame);
        outputView.printTotalGameAttempts(bridgeGame);
    }
}
