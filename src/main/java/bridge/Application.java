package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.utils.BridgeNumberGenerator;
import bridge.utils.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        OutputView.printGameStart();
        InputView.readBridgeSize();
        new Bridge(bridgeNumberGenerator);
        bridgeGame.start();
    }
}
