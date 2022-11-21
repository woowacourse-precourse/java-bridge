package bridge;

import bridge.domain.BridgeGameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(final String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        try {
            new BridgeGameController(inputView, outputView, bridgeMaker).play();
        } catch (final IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
