package bridge;

import java.util.List;

public class Application {

    private static InputView inputView = InputView.getInstance();
    private static OutputView outputView = OutputView.getInstance();
    BridgeGame bridgeGame = BridgeGame.getInstance();

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
            isGameContinued = isContinued(bridge);
        }
    }

    private boolean isContinued(Bridge bridge) {
        if (bridgeGame.isUserDead(bridge)) {
            return bridgeGame.retry(inputView.readGameCommand());
        }

        return ! bridgeGame.isOver(bridge);
    }

    private void exitGame(Bridge bridge) {
        outputView.printResult(bridge, bridgeGame, bridgeGame.getRetryCount());
    }
}
