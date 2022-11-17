package bridge.controller;

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
        /*BridgeGame bridgeGame = createNewGame();
        do {

        } while(continue)*/
    }

    public int getBridgeSize() {
        String input = "";
        do {
            outputView.printGameMessage(GameMessage.ASK_BRIDGE_SIZE);
            input = inputView.readBridgeSize();
        } while (!validateBridgeSizeInput(input));
        return Integer.parseInt(input);
    }

    public boolean validateBridgeSizeInput(String input) {
        try {
            InputValidator.validateBridgeSize(input);
            return true;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(ErrorMessage.INVALID_BRIDGE_SIZE,
                    BridgeSizeConstant.LOWER_BOUND.getValue(), BridgeSizeConstant.UPPER_BOUND.getValue());
            exception.printStackTrace();
            return false;
        }
    }
}
