package bridge;

import java.util.List;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    private static int retryCount = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();

        Bridge bridge = new Bridge(app.initializeBridge());
        app.crossBridge(bridge);
        app.exitGame(bridge);
    }

    private List<String> initializeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private void crossBridge(Bridge bridge) {
        boolean isGameContinued = true;

        while(isGameContinued) {
            outputView.printMap(bridge, bridgeGame.move(inputView.readMoving()));
            if (bridgeGame.isUserDead(bridge)) {
                isGameContinued = bridgeGame.retry(inputView.readGameCommand());
                retryCount++;
            }
        }
    }

    private void exitGame(Bridge bridge) {
        outputView.printResult(bridge, bridgeGame, retryCount);
    }
}
