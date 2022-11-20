package bridge;

import bridge.controller.BridgeGameMachine;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.SystemConsole;

public class Application {

    public static void main(String[] args) {
        BridgeGameMachine bridgeGameMachine = new BridgeGameMachine(
                new InputView(), new OutputView(), new SystemConsole());
        bridgeGameMachine.run();
    }
}
