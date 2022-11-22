package bridge;

public class Application {
    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeData bridgeData = new BridgeData(bridgeMaker.makeBridge(InputView.readBridgeSize()), 0);
        startGame(bridgeData);
        OutputView.printResult(bridgeData, BridgeGame.gameStatus, BridgeGame.gameCount);
    }

    private static void startGame(BridgeData bridgeData) {
        while (bridgeData.getBridge().size() > bridgeData.getCurrentPosition() && BridgeGame.gameStatus) {
            if (BridgeGame.move(bridgeData, InputView.readMoving())) {
                OutputView.printMap(bridgeData, true);
                continue;
            }
            OutputView.printMap(bridgeData, false);
            BridgeGame.retry(bridgeData, InputView.readGameCommand());
        }
    }
}