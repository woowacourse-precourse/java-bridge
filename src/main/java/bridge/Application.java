package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameMachine bridgeGameMachine = new BridgeGameMachine(
                new InputView(),
                new OutputView());
        bridgeGameMachine.play();
    }
}
