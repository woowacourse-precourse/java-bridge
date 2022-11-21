package bridge.controller;

import static bridge.constant.Message.ENTER_BRIDGE_LENGTH;
import static bridge.constant.Message.ENTER_MOVE_DIRECTION;
import static bridge.constant.Message.ENTER_RETRY_OR_QUIT;
import static bridge.constant.Message.START_MESSAGE;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.constant.Message;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;
    private boolean playing;

    private int countTry;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        playing = true;
        countTry = 1;
    }

    public void start() {
        outputView.printMessageWithNewLine(START_MESSAGE);
        setUpBridge();
        // TODO: 정답 출력문 지우기
        System.out.println(bridgeGame.getAnswerBridge().getBridge());
        while (playing) {
            moveToDirection();
            outputView.printMap(bridgeGame);
            if (!bridgeGame.getMoveState()) {
                gameRetryOrQuit();
            }
            if (bridgeGame.isClear()) {
                playing = false;
            }
        }
        outputView.printResult(bridgeGame, countTry);
    }

    private void setUpBridge() {
        try {
            outputView.printMessage(ENTER_BRIDGE_LENGTH);
            int size = inputView.readBridgeSize();
            bridgeGame = new BridgeGame(new Bridge(size));
            outputView.printNewLine();
        } catch (IllegalArgumentException ex) {
            outputView.printErrorMessage(ex.getMessage());
            setUpBridge();
        }
    }

    private void moveToDirection() {
        try {
            outputView.printMessage(ENTER_MOVE_DIRECTION);
            String direction = inputView.readMoving();
            bridgeGame.move(direction);
        } catch (IllegalArgumentException ex) {
            outputView.printErrorMessage(ex.getMessage());
            moveToDirection();
        }
    }

    private void gameRetryOrQuit() {
        try {
            outputView.printMessage(ENTER_RETRY_OR_QUIT);
            boolean retry = inputView.readGameCommand();
            if (retry) {
                bridgeGame.retry();
                countTry += 1;
            }
            if (!retry) {
                playing = false;
            }
        } catch (IllegalArgumentException ex) {
            outputView.printErrorMessage(ex.getMessage());
            gameRetryOrQuit();
        }
    }
}