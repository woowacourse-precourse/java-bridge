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
        // 주석 지우기
        System.out.println(bridgeGame.getAnswerBridge().getBridge());
        while(true) {
            String direction = getMoveDirection();
            boolean canGo = bridgeGame.move(direction);
            outputView.printMap(bridgeGame);
            if (!canGo) {
                getGameRetryOrQuit();
                break; // TODO: 추가 구현
            }
        }
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

    private String getMoveDirection() {
        String direction = null;
        try {
            outputView.printMessage(ENTER_MOVE_DIRECTION.toString());
            direction = inputView.readMoving();
        } catch (IllegalArgumentException ex) {
            outputView.printMessage(ex.getMessage());
            getMoveDirection();
        }
        return direction;
    }

    private String getGameRetryOrQuit() {
        try {
            outputView.printMessage(ENTER_RETRY_OR_QUIT.toString());
            inputView.readGameCommand();
        } catch (IllegalArgumentException ex) {
            outputView.printMessage(ex.getMessage());
            getGameRetryOrQuit();
        }
        return null;
    }
}
