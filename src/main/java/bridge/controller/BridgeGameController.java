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
            outputView.printMap(bridgeGame.printResult(false));
            retry();
            return;
        }
        continueOrSuccess();
    }

    private void continueOrSuccess() {
        if (!bridgeGame.isCompletedGame()) {
            outputView.printMap(bridgeGame.printResult(true));
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
        outputView.printGameOverMessage();
        outputView.printMap(bridgeGame.printResult(true));
        outputView.printResult(OutputView.SUCCESS_MESSAGE, bridgeGame.getRetryCount());
    }

    private void printFailureResult() {
        outputView.printGameOverMessage();
        outputView.printMap(bridgeGame.printResult(false));
        outputView.printResult(OutputView.FAILURE_MESSAGE, bridgeGame.getRetryCount());
    }
}
