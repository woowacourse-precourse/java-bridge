package bridge;

import bridge.controller.BridgeGameMachine;
import bridge.domain.ValidateInput;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BridgeGameMachine bridgeGameMachine = new BridgeGameMachine(
                new InputView(new ValidateInput()), new OutputView());
        bridgeGameMachine.run();
    }
}