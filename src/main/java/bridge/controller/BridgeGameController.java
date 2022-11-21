package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.Position;
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
        createNewGame(bridgeSize);
        play();
    }

    private void createNewGame(int bridgeSize) {
        this.bridgeGame = new BridgeGame(bridgeSize, new BridgeRandomNumberGenerator());
    }

    private void play() {
        String moving = inputView.readMoving();
        move(Position.create(moving));
    }

    private void move(Position position) {
        if (!isMoveSuccess(position)) {
            outputView.printMap(bridgeGame.printResult());
            retry();
            return;
        }
        outputView.printMap(bridgeGame.printResult());
        continueOrSuccess();
    }

    private boolean isMoveSuccess(Position position) {
        return bridgeGame.move(position);
    }

    private void continueOrSuccess() {
        if (!isCompletedGame()) {
            play();
            return;
        }
        printResult(SUCCESS_MESSAGE);
    }

    private boolean isCompletedGame() {
        return bridgeGame.isCompletedGame();
    }

    private void retry() {
        String answer = inputView.readGameCommand();
        if (isInputRetry(answer)) {
            bridgeGame.retry();
            play();
            return;
        }
        printResult(FAILURE_MESSAGE);
    }

    private static boolean isInputRetry(String answer) {
        return answer.equals(RETRY_SIGNAL);
    }

    private void printResult(String message) {
        outputView.printGameOverMessage();
        outputView.printMap(bridgeGame.printResult());
        outputView.printResult(message, bridgeGame.getRetryCount());
    }
}
