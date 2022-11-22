package bridge.controller;

import static bridge.constant.GameCommand.R;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView,
        BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void startGame() {
        outputView.printStartPhrase();
        outputView.printInputBridgeSizePhrase();
        bridgeGame.setBridge(inputView.readBridgeSize());
    }

    public void onGame() {
        outputView.printOnGamePhrase();
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame);
    }

    public boolean isNotEnd() {
        if (bridgeGame.isFinished()) {
            return false;
        }
        if (bridgeGame.isNotFail()) {
            return true;
        }
        return chooseRetryOrQuit();
    }

    private boolean chooseRetryOrQuit() {
        outputView.printRetryOrQuitPhrase();
        if (isRetry()) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private boolean isRetry() {
        return inputView.readGameCommand() == R;
    }

    public void endGame() {
        outputView.printResult(bridgeGame);
    }

    public void handleException(RuntimeException exception) {
        outputView.printExceptionMessage(exception);
    }
}
