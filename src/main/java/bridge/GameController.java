package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    public void start() {
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        printStart();

        List<String> rightBridgeWay = bridgeMaker.makeBridge(inputBridgeSize());

        BridgeGame bridgeGame = new BridgeGame();
        makeUpperAndLowerBridge(rightBridgeWay, bridgeGame);

        printResult(bridgeGame);
    }

    private void printStart() {
        OutputView.printStart();
    }

    private int inputBridgeSize() {
        return InputView.readBridgeSize();
    }

    public void makeUpperAndLowerBridge(List<String> rightBridgeWay, BridgeGame bridgeGame) {
        boolean keepGoing = true;
        while (keepGoing && bridgeGame.getBridgeIndex() < rightBridgeWay.size()) {
            String inputMoveValue = readMoving();
            bridgeGame.move(rightBridgeWay, inputMoveValue);
            printMap(bridgeGame.upperBridge, bridgeGame.lowerBridge);

            if (bridgeGame.upperBridge.contains(OutputView.WRONG_WAY_SIGN) || bridgeGame.lowerBridge.contains(OutputView.WRONG_WAY_SIGN)) {
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
        String reGame = InputView.readGameCommand();
        return bridgeGame.retry(reGame);
    }

    private void printResult(BridgeGame bridgeGame) {
        OutputView.printResult(bridgeGame);
    }
}
