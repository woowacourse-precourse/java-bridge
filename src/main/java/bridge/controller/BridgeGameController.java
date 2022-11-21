package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    public static final String RETRY_SIGNAL = "R";
    public static final String SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    public static final String FAILURE_MESSAGE = "게임 성공 여부: 실패";
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
            outputView.printMap(bridgeGame.printResult());
            retry();
            return;
        }
        continueOrSuccess();
    }

    private void continueOrSuccess() {
        if (!bridgeGame.isCompletedGame()) {
            outputView.printMap(bridgeGame.printResult());
            play();
            return;
        }
        printResult(SUCCESS_MESSAGE);
    }

    private void retry() {
        String answer = inputView.readGameCommand();
        if (answer.equals(RETRY_SIGNAL)) {
            bridgeGame.retry();
            play();
            return;
        }
        printResult(FAILURE_MESSAGE);
    }

    private void printResult(String message) {
        outputView.printGameOverMessage();
        outputView.printMap(bridgeGame.printResult());
        outputView.printResult(message, bridgeGame.getRetryCount());
    }
}
