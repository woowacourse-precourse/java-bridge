package bridge.controller;

import bridge.model.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
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
        this.printStart();
        this.createNewGame(readBridgeSize());
        this.play();
    }

    private void printStart() {
        this.outputView.printStart();
    }

    private int readBridgeSize() {
        return inputView.readBridgeSize();
    }

    private void createNewGame(int bridgeSize) {
        this.bridgeGame = new BridgeGame(bridgeSize, new BridgeRandomNumberGenerator());
    }

    private void play() {
        this.move(Position.create(readMoving()));
    }

    private String readMoving() {
        return this.inputView.readMoving();
    }

    private void move(Position position) {
        if (!this.isMoveSuccess(position)) {
            this.gameOver();
            return;
        }
        this.continueGame();
    }

    private void gameOver() {
        printMap(this.bridgeGame);
        this.retry();
    }

    private boolean isMoveSuccess(Position position) {
        return this.bridgeGame.move(position);
    }

    private void continueGame() {
        printMap(this.bridgeGame);
        if (!this.isCompletedGame()) {
            this.play();
            return;
        }
        this.printGameResult(SUCCESS_MESSAGE);
    }

    private boolean isCompletedGame() {
        return this.bridgeGame.isCompletedGame();
    }

    private void retry() {
        String answer = this.inputView.readGameCommand();
        if (this.isInputRetry(answer)) {
            initBridgeGame();
            this.play();
            return;
        }
        this.printGameResult(FAILURE_MESSAGE);
    }

    private void initBridgeGame() {
        this.bridgeGame.retry();
    }

    private boolean isInputRetry(String answer) {
        return answer.equals(RETRY_SIGNAL);
    }

    private void printGameResult(String message) {
        this.printGameOverMessage();
        this.printMap(bridgeGame);
        this.printGameReport(message);
    }

    private void printGameOverMessage() {
        this.outputView.printGameOverMessage();
    }

    private void printGameReport(String message) {
        this.outputView.printResult(message, bridgeGame.getRetryCount());
    }

    private void printMap(BridgeGame bridgeGame) {
        this.outputView.printMap(bridgeGame.printResult());
    }
}
