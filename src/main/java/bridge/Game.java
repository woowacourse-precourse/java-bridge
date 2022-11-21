package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Game {

    static int size;
    static BridgeGame bridgeGame;

    public Game() {
        makeBridge();
    }

    private void makeBridge() {
        this.size = InputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker user = new BridgeMaker(bridgeNumberGenerator);
        List<String> userBridge = user.makeBridge(size);
        this.bridgeGame = new BridgeGame(userBridge);
        System.out.println(userBridge);
    }
}
