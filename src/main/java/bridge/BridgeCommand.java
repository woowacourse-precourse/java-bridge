package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeCommand {

    public BridgeCommand() {
    }

    public String getRetry() {
        new OutputView().printRetryGameMessage();
        return new InputView().readGameCommand();
    }
}
