package bridge;

import java.util.List;

public class GameController {

    public void start() {
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        printStart();

        List<String> rightBridgeWay = bridgeMaker.makeBridge(inputBridgeSize());

        BridgeGame bridgeGame = new BridgeGame();
        makeUpperAndLowerBridge(rightBridgeWay,bridgeGame);

        printResult(bridgeGame);
    }

    private void printStart() {
        OutputView.printStart();
    }

    private int inputBridgeSize() {
        return InputView.readBridgeSize();
    }

    public void makeUpperAndLowerBridge (List<String> rightBridgeWay, BridgeGame bridgeGame) {
        boolean keepGoing = true;
        while(keepGoing && bridgeGame.bridgeIndex < rightBridgeWay.size()) {
            String inputMoveValue = readMoving();
            bridgeGame.move(rightBridgeWay, inputMoveValue);
            printMap(bridgeGame.upperBridge, bridgeGame.lowerBridge);

            if (bridgeGame.upperBridge.contains("X") || bridgeGame.lowerBridge.contains("X")) {
                keepGoing = retryGame(bridgeGame);
            }
        }
    }

    private String readMoving() {
        return InputView.readMoving();
    }

    private void printMap(List<String> upperBridge, List<String> lowerBridge) {
        OutputView.printMap(upperBridge, lowerBridge);
    }

    private boolean retryGame(BridgeGame bridgeGame) {
        String inputReGame = InputView.readGameCommand();
        return bridgeGame.retry(inputReGame);
    }

    private void printResult(BridgeGame bridgeGame) {
        OutputView.printResult(bridgeGame);
    }
}
