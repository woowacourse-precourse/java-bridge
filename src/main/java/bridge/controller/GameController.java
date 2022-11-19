package bridge.controller;

import bridge.constants.InputMessage;
import bridge.service.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputMessage inputMessage = new InputMessage();
    private final Validator validator = new Validator();
    public void startGame() {
        inputView.printMessage(inputMessage.START_GAME);
        int bridgeSize = inputView.readBridgeSize();
        setBridgeSize(bridgeSize);
    }
    public void setBridgeSize(int bridgeSize) {
        try {
            validator.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            bridgeSize = inputView.readBridgeSize();
            setBridgeSize(bridgeSize);
        }
    }
}
