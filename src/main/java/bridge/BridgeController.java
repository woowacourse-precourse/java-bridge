package bridge;

import bridge.domain.InputValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final InputValidator inputValidator = new InputValidator();

    private int getInputBridgeSize() {
        try {
            String bridgeSize = inputView.readBridgeSize();
            inputValidator.validateBridgeSize(bridgeSize);
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputBridgeSize();
        }
    }

    private String getInputMoving() {
        try {
            String moving = inputView.readMoving();
            inputValidator.validateMoving(moving);
            return moving;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputMoving();
        }
    }

    private boolean isInputGameCommandRetry() {
        try {
            String gameCommand = inputView.readGameCommand();
            inputValidator.validateGameCommand(gameCommand);
            return gameCommand.equals(Constants.CODE_RETRY);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return isInputGameCommandRetry();
        }
    }
}
