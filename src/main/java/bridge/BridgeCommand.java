package bridge;

import bridge.domain.Result;
import bridge.validation.InputValidation;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

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

    public void printGameSetMessages(List<Result> crossResult, boolean isCleared, int totalGameCount) {
        OutputView outputView = new OutputView();
        outputView.printResult(crossResult, isCleared, totalGameCount);
    }
}
