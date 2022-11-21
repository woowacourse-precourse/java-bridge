package bridge.controller;

import static bridge.constant.Message.ENTER_BRIDGE_LENGTH;
import static bridge.constant.Message.ENTER_MOVE_DIRECTION;
import static bridge.constant.Message.ENTER_RETRY_OR_QUIT;

import bridge.Bridge;
import bridge.BridgeGame;
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
        countTry = 0;
    }

    public void start() {
        outputView.printStart();
        setUpBridge();
        // TODO: 정답 출력문 지우기
        System.out.println(bridgeGame.getAnswerBridge().getBridge());
        while (playing) {
            moveToDirection();
            outputView.printMap(bridgeGame);
            if (!bridgeGame.getMoveState()) {
                gameRetryOrQuit();
            }
        }
        outputView.printResult(); //TODO: 구현해야함
    }

    private void setUpBridge() {
        try {
            outputView.printMessage(ENTER_BRIDGE_LENGTH.toString());
            int size = inputView.readBridgeSize();
            bridgeGame = new BridgeGame(new Bridge(size));
        } catch (IllegalArgumentException ex) {
            outputView.printMessage(ex.getMessage());
            setUpBridge();
        }
    }

    private void moveToDirection() {
        try {
            outputView.printMessage(ENTER_MOVE_DIRECTION.toString());
            String direction = inputView.readMoving();
            bridgeGame.move(direction);
        } catch (IllegalArgumentException ex) {
            outputView.printMessage(ex.getMessage());
            moveToDirection();
        }
    }

    private void gameRetryOrQuit() {
        try {
            outputView.printMessage(ENTER_RETRY_OR_QUIT.toString());
            boolean retry = inputView.readGameCommand();
            if (retry) {
                bridgeGame.retry();
                countTry += 1;
            }
            if (!retry) {
                playing = false;
            }
        } catch (IllegalArgumentException ex) {
            outputView.printMessage(ex.getMessage());
            gameRetryOrQuit();
        }
    }
}