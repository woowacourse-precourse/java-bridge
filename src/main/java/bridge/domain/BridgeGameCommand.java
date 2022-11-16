package bridge.domain;

import bridge.validator.BridgeGameCommandValidator;
import bridge.view.ErrorView;
import bridge.view.InputView;

public class BridgeGameCommand {

    private final InputView inputView;

    public BridgeGameCommand() {
        this.inputView = new InputView();
    }

    public String getMovingCommand() {
        while (true) {
            try {
                return BridgeGameCommandValidator.movingCommandValidation(this.inputView.readMoving());
            } catch (IllegalArgumentException illegalArgumentException) {
                ErrorView.printException(illegalArgumentException);
            }
        }
    }

    public String getRetryCommand() {
        while (true) {
            try {
                return BridgeGameCommandValidator.retryCommandValidation(this.inputView.readGameCommand());
            } catch (IllegalArgumentException illegalArgumentException) {
                ErrorView.printException(illegalArgumentException);
            }
        }
    }
}
