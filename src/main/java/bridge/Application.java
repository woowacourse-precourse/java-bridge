package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = initBridgeGameController();
        bridgeGameController.run();
    }

    private static BridgeGameController initBridgeGameController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ConsoleController consoleController = new ConsoleController(outputView, inputView);
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        return new BridgeGameController(consoleController,bridgeMaker);
    }
}
