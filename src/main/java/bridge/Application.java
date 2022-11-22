package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController bridgeGameController = initBridgeGameController();
            bridgeGameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static BridgeGameController initBridgeGameController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        return new BridgeGameController(inputView, outputView, bridgeMaker);
    }
}
