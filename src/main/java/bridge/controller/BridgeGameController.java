package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    private int getMakeBridgeSize() {
        String input;

        do {
            input = inputView.readBridgeSize();
        } while (!validateInputSetting(input));

        return Integer.parseInt(input);
    }

    private boolean validateInputSetting(String userInput) {
        try {
            bridgeGame.validateBridgeSize(userInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return false;
        }

        return true;
    }

    private void gameSetting(int bridgeSize) {
        bridgeGame.initBridge(bridgeSize);
    }

    private boolean isDisallowInputMoveCommand(String input) {
        try {
            bridgeGame.validateInputMoveCommand(input);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return true;
        }
        return false;
    }

}
