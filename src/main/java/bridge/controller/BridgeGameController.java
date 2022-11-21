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
        this.outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        this.createNewGame(bridgeSize);
        this.play();
    }

    private void createNewGame(int bridgeSize) {
        this.bridgeGame = new BridgeGame(bridgeSize, new BridgeRandomNumberGenerator());
    }

    private void play() {
        String moving = this.inputView.readMoving();
        this.move(Position.create(moving));
    }

    private void move(Position position) {
        if (!this.isMoveSuccess(position)) {
            this.outputView.printMap(this.bridgeGame.printResult());
            this.retry();
            return;
        }
        this.outputView.printMap(this.bridgeGame.printResult());
        this.continueOrSuccess();
    }

    private boolean isMoveSuccess(Position position) {
        return this.bridgeGame.move(position);
    }

    private void continueOrSuccess() {
        if (!this.isCompletedGame()) {
            this.play();
            return;
        }
        this.printResult(SUCCESS_MESSAGE);
    }

    private boolean isCompletedGame() {
        return this.bridgeGame.isCompletedGame();
    }

    private void retry() {
        String answer = this.inputView.readGameCommand();
        if (this.isInputRetry(answer)) {
            this.bridgeGame.retry();
            this.play();
            return;
        }
        this.printResult(FAILURE_MESSAGE);
    }

    private boolean isInputRetry(String answer) {
        return answer.equals(RETRY_SIGNAL);
    }

    private void printResult(String message) {
        this.outputView.printGameOverMessage();
        this.outputView.printMap(bridgeGame.printResult());
        this.outputView.printResult(message, bridgeGame.getRetryCount());
    }
}
