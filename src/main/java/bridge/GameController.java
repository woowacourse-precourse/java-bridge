package bridge;

import java.util.List;

public class GameController {

    public void start() {
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        OutputView.printStart();

        List<String> rightBridgeWay = bridgeMaker.makeBridge(InputView.readBridgeSize());

        BridgeGame bridgeGame = new BridgeGame();
    }
}
