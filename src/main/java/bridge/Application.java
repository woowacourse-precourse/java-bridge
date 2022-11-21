package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        OutputView.printGameStart();
        InputView.readBridgeSize();
        new Bridge();
        bridgeGame.start();
    }
}
