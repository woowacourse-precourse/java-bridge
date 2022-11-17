package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.printStart();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge, 0, true);
        playGame(bridgeGame);
    }

    public static void playGame(BridgeGame bridgeGame) {
        while (bridgeGame.position != bridgeGame.bridge.size() && bridgeGame.flag) {
            bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame.map);
        }

    }
}
