package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
        while (bridgeGame.move(inputView.readMoving()) || bridgeGame.retry(inputView.readGameCommand())) {
            outputView.printMap(bridgeGame.upperBridge, bridgeGame.bottomBridge);
        }
        outputView.printResult(bridgeGame.upperBridge, bridgeGame.bottomBridge);
    }
}