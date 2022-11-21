package bridge.game;

import bridge.validation.BridgeMoveValidation;
import bridge.validation.BridgeSizeValidation;

import bridge.validation.RetryValidation;
import bridge.view.InputView;

public class Function {
    private static final InputView inputView = new InputView();
    private static final BridgeSizeValidation sizeValidation = new BridgeSizeValidation();
    private static final BridgeMoveValidation moveValidation = new BridgeMoveValidation();
    private static final RetryValidation tryValidation = new RetryValidation();


    public String sizeValidation() {
        try {
            String input = inputView.readBridgeSize();
            sizeValidation.bridgeSizeValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return sizeValidation();
        }
    }

    public String moveValidation() {
        try {
            String input = inputView.readMoving();
            moveValidation.bridgeMoveValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return moveValidation();
        }
    }

    public String retryValidation() {
        try {
            String input = inputView.readGameCommand();
            tryValidation.retryValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryValidation();
        }
    }
}
