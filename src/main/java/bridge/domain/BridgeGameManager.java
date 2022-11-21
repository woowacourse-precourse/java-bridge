package bridge.domain;

import bridge.view.input.InputView;
import bridge.view.output.OutputView;

public class BridgeGameManager {

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeState bridgeState = new BridgeState();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private int bridgeLength = 0;

    public void start() {
        introBridgeGame();
        BridgeGame bridgeGame = makeBridgeGame();
        mainProgress(bridgeGame);
        printGameResult(bridgeGame);
    }

    private void introBridgeGame() {
        outputView.printGameStartNotification();
        outputView.printInputBridgeLengthNotification();
    }

    private BridgeGame makeBridgeGame() {
        return new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()), bridgeState);
    }

    private void mainProgress(BridgeGame bridgeGame) {
        initBrigeLength(bridgeGame);
        while (bridgeLength --> 0) {
            moveProgress(bridgeGame);
            if (!bridgeGame.isWon() && isQuit(bridgeGame)) {
                break;
            }
        }
    }

    private void initBrigeLength(BridgeGame bridgeGame) {
        bridgeLength = bridgeGame.getBridgeLength();
    }

    private void moveProgress(BridgeGame bridgeGame) {
        outputView.printInputArrow();
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeState);
    }

    private boolean isQuit(BridgeGame bridgeGame) {
        outputView.printInputRetryOrNot();
        if (inputView.readGameCommand().equals("R")) {
            bridgeGame.retry();
            initBrigeLength(bridgeGame);
            return false;
        }
        return true;
    }

    private void printGameResult(BridgeGame bridgeGame) {
        outputView.printResult(bridgeState);
        outputView.printGameResult(bridgeGame);
        outputView.printTotalGameAttempts(bridgeGame);
    }
}
