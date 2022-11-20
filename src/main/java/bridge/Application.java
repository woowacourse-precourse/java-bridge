package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(InputView.readBridgeSize());
        while ((bridgeGame.move(InputView.readMoving()) || bridgeGame.retry(InputView.readGameCommand()))) {
            OutputView.printMap(bridgeGame.upperBridge, bridgeGame.bottomBridge);
            if (bridgeGame.clearCheck()) {
                break;
            }
        }
        OutputView.printResult(bridgeGame.upperBridge, bridgeGame.bottomBridge);
    }
}