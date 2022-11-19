package bridge;

import java.util.List;

public class GameController {

    public void start() {
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        OutputView.printStart();

        List<String> rightBridgeWay = bridgeMaker.makeBridge(InputView.readBridgeSize());

        BridgeGame bridgeGame = new BridgeGame();
        makeUpperAndLowerBridge(rightBridgeWay,bridgeGame);

    }

    public void makeUpperAndLowerBridge (List<String> rightBridgeWay, BridgeGame bridgeGame) {
        int attempt = rightBridgeWay.size();
        System.out.println(rightBridgeWay);

        for (int i = attempt; i > 0 ; i--) {
            String movingValue = InputView.readMoving();
            bridgeGame.move(rightBridgeWay, movingValue);
            OutputView.printMap(bridgeGame.upperBridge,bridgeGame.lowerBridge);
        }
    }


}
