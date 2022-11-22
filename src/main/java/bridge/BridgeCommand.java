package bridge;

import bridge.validation.InputValidation;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeCommand {

    public BridgeCommand() {
    }

    public String getRetry() {
        OutputView outputView = new OutputView();
        outputView.printRetryGameMessage();
        while (true) {
            try {
                return new InputValidation().getCommand(new InputView().readGameCommand());
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }

    }
}
