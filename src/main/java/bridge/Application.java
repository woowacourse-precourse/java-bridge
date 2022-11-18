package bridge;

import bridge.domain.BridgeApplication;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeApplication bridgeApplication = new BridgeApplication(new InputView(), new OutputView());
        bridgeApplication.run();
    }
}
