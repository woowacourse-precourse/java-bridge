package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeMaker, inputView, outputView);

        runControllerWithPrintError(bridgeGameController, outputView);
    }

    private static void runControllerWithPrintError(BridgeGameController bridgeGameController, OutputView outputView) {
        try {
            bridgeGameController.run();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            throw e;
        }
    }
}
