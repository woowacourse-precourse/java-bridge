package bridge;

import bridge.Controller.BridgeGame;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.run();
        } catch (IllegalArgumentException exception) {
            OutputView outputView = new OutputView();
            outputView.printError(exception.getMessage());
        }
    }
}
