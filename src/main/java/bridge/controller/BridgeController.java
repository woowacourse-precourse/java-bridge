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

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        outputView.printStart();
        setUpBridge();
        // TODO: 정답 출력문 지우기
        System.out.println(bridgeGame.getAnswerBridge().getBridge());
        while(true) {
            moveToDirection();
            outputView.printMap(bridgeGame);
            if (!bridgeGame.getMoveState()) {
                gameRetryOrQuit();
                break;
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
        } catch (IllegalArgumentException ex) {
            outputView.printMessage(ex.getMessage());
            gameRetryOrQuit();
        }
    }
}
