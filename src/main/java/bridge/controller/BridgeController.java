package bridge.controller;

import static bridge.constant.Message.ENTER_BRIDGE_LENGTH;
import static bridge.constant.Message.ENTER_MOVE_DIRECTION;
import static bridge.constant.Message.ENTER_RETRY_OR_QUIT;
import static bridge.constant.Message.START_MESSAGE;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;
    private boolean playing;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        playing = true;
    }

    public void start() {
        outputView.printMessageWithNewLine(START_MESSAGE);
        setUpBridge();
        // TODO: 정답 출력문 지우기
        System.out.println(bridgeGame.getAnswerBridge().getBridge());
        playGame();
        outputView.printResult(bridgeGame);
    }

    private void setUpBridge() {
        try {
            outputView.printMessage(ENTER_BRIDGE_LENGTH);
            bridgeGame = new BridgeGame(new Bridge(inputView.readBridgeSize()));
            outputView.printNewLine();
        } catch (IllegalArgumentException ex) {
            outputView.printErrorMessage(ex.getMessage());
            setUpBridge();
        }
    }

    private void playGame() {
        while (playing) {
            moveToDirection();
            keepPlaying();
        }
    }

    private void moveToDirection() {
        try {
            outputView.printMessage(ENTER_MOVE_DIRECTION);
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
        } catch (IllegalArgumentException ex) {
            outputView.printErrorMessage(ex.getMessage());
            moveToDirection();
        }
    }

    private void keepPlaying() {
        if (!bridgeGame.getMoveState()) {
            gameRetryOrQuit();
        }
        if (playing) {
            playing = bridgeGame.isClearGame();
        }
    }

    private void gameRetryOrQuit() {
        try {
            outputView.printMessage(ENTER_RETRY_OR_QUIT);
            changeGameStatus(inputView.readGameCommand());
        } catch (IllegalArgumentException ex) {
            outputView.printErrorMessage(ex.getMessage());
            gameRetryOrQuit();
        }
    }

    private void changeGameStatus(boolean retry) {
        if (retry) {
            bridgeGame.retry();
            return;
        }
        playing = false;
    }
}