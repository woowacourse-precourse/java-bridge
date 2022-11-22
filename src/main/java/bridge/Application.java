package bridge;

import bridge.bridgeGame.BridgeGame;
import bridge.inputView.InputView;
import bridge.outputView.OutputView;

public class Application {

    public static void main(String[] args) {
        new BridgeGame(new InputView(), new OutputView(), new BridgeRandomNumberGenerator()).play();
    }
}
