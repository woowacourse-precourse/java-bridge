package bridge;

import ui.InputView;
import ui.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame(outputView, inputView);
        bridgeGame.run();
    }
}
