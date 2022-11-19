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

        OutputView.printResult(bridgeGame);

    }

    public void makeUpperAndLowerBridge (List<String> rightBridgeWay, BridgeGame bridgeGame) {
        boolean keepGoing = true;
        while(keepGoing && bridgeGame.bridgeIndex < rightBridgeWay.size()) {
            String inputMoveValue = InputView.readMoving();
            bridgeGame.move(rightBridgeWay, inputMoveValue);
            OutputView.printMap(bridgeGame.upperBridge, bridgeGame.lowerBridge);

            if (bridgeGame.upperBridge.contains("X") || bridgeGame.lowerBridge.contains("X")) {
                keepGoing = retryGame(bridgeGame);
            }
        }
    }

    public boolean retryGame(BridgeGame bridgeGame) {
        String inputReGame = InputView.readGameCommand();
        return bridgeGame.retry(inputReGame);
    }

}
