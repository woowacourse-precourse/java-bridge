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

        //
        //
    }

    public void makeUpperAndLowerBridge (List<String> rightBridgeWay, BridgeGame bridgeGame) {
        int attempt = rightBridgeWay.size();
        System.out.println(rightBridgeWay);  // 제거해야함
        boolean keepGoing = true;
        while(keepGoing) {
            String movingValue = InputView.readMoving(); // movingValue -> inputMoveValue로 수정필요
            bridgeGame.move(rightBridgeWay, movingValue);
            OutputView.printMap(bridgeGame.upperBridge, bridgeGame.lowerBridge);

            if (bridgeGame.upperBridge.contains("X") || bridgeGame.lowerBridge.contains("X")) {
                keepGoing = retryGame(bridgeGame);
            }
        }
    }

    public boolean retryGame(BridgeGame bridgeGame) {
        String inputRegame = InputView.readGameCommand();
        return bridgeGame.retry(inputRegame);
    }

}
