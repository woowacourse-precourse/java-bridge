package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    public static final String RETRY_SIGNAL = "R";
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize, new BridgeRandomNumberGenerator());
        play();
    }

    private void play() {
        String moving = inputView.readMoving();
        move(moving);
    }

    private void move(String moving) {
        if (!bridgeGame.move(moving)) {
            outputView.printMap(bridgeGame.printWrongResult());
            retry();
            return;
        }
        continueOrSuccess();
    }

    private void continueOrSuccess() {
        if (!bridgeGame.isSuccess()) {
            outputView.printMap(bridgeGame.printRightResult());
            play();
            return;
        }
        printSuccessResult();
    }

    private void retry() {
        String answer = inputView.readGameCommand();
        if (answer.equals(RETRY_SIGNAL)) {
            bridgeGame.retry();
            play();
            return;
        }
        printFailureResult();
    }

    private void printSuccessResult() {
        outputView.printOverMessage();
        outputView.printMap(bridgeGame.printRightResult());
        outputView.printResult(OutputView.SUCCESS_MESSAGE, bridgeGame.getRetryCount());
    }

    private void printFailureResult() {
        outputView.printOverMessage();
        outputView.printMap(bridgeGame.printWrongResult());
        outputView.printResult(OutputView.FAILURE_MESSAGE, bridgeGame.getRetryCount());
    }
}
