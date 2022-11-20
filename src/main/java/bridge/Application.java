package bridge;

import bridge.controller.BridgeGameMachine;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BridgeGameMachine bridgeGameMachine = new BridgeGameMachine(
                new InputView(), new OutputView());

        try {
            bridgeGameMachine.run();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
