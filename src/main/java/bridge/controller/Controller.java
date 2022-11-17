package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeSizeConstant;
import bridge.model.InputValidator;
import bridge.view.ErrorMessage;
import bridge.view.GameMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        getBridgeSize();
    }
    /*public BridgeGame createNewGame() {

    }*/
    public int getBridgeSize() {
        String input = "";
        boolean isInvalidInput = true;
        do {
            try {
                outputView.printGameMessage(GameMessage.ASK_BRIDGE_SIZE);
                input = inputView.readBridgeSize();
                InputValidator.validateBridgeSize(input);
                isInvalidInput = false;
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(ErrorMessage.INVALID_BRIDGE_SIZE,
                        BridgeSizeConstant.LOWER_BOUND.getValue(), BridgeSizeConstant.UPPER_BOUND.getValue());
                exception.printStackTrace();
            }
        } while (isInvalidInput);
        return Integer.parseInt(input);
    }
}
