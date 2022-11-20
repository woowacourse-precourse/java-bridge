package bridge.controller;

import static bridge.constant.Message.ENTER_BRIDGE_LENGTH;
import static bridge.constant.Message.ENTER_MOVE_DIRECTION;
import static bridge.constant.Message.ENTER_RETRY_OR_QUIT;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStart();
        Bridge bridge = new Bridge(getBridge(getBridgeSize()));
        BridgeGame bridgeGame = new BridgeGame(bridge);
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

    private int getBridgeSize() {
        int size = 0;
        try {
            outputView.printMessage(ENTER_BRIDGE_LENGTH.toString());
            size = inputView.readBridgeSize();
        } catch (IllegalArgumentException ex) {
            outputView.printMessage(ex.getMessage());
            getBridgeSize();
        }
        return size;
    }

    private List<String> getBridge(int size) {
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        return bridge;
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
