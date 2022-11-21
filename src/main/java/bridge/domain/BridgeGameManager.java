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
        introBridgeGame();
        BridgeGame bridgeGame = makeBridgeGame();
        mainProgress(bridgeGame);
        printGameResult(bridgeGame);
    }

    private void introBridgeGame() {
        outputView.printGameStartNotification();
        outputView.printInputBridgeSizeNotification();
    }

    private BridgeGame makeBridgeGame() {
        return new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()), bridgeState);
    }

    private void mainProgress(BridgeGame bridgeGame) {
        initBrigeSize(bridgeGame);
        while (bridgeSize --> BRIDGE_SIZE_INIT) {
            moveProgress(bridgeGame);
            if (!bridgeGame.isWon() && !isRetry(bridgeGame)) {
                break;
            }
        }
    }

    private void initBrigeSize(BridgeGame bridgeGame) {
        bridgeSize = bridgeGame.getBridgeSize();
    }

    private void moveProgress(BridgeGame bridgeGame) {
        outputView.printInputArrow();
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeState);
    }

    private boolean isRetry(BridgeGame bridgeGame) {
        outputView.printInputRetryOrNot();
        String command = inputView.readGameCommand();
        if (bridgeGame.retry(command)) {
            initBrigeSize(bridgeGame);
            return true;
        }
        return false;
    }

    private void printGameResult(BridgeGame bridgeGame) {
        outputView.printResult(bridgeState);
        outputView.printGameResult(bridgeGame);
        outputView.printTotalGameAttempts(bridgeGame);
    }
}
