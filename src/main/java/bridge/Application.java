package bridge;

import java.util.List;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();

        Bridge bridge = new Bridge(app.initializeBridge());
        app.crossBridge(bridge);
    }

    private List<String> initializeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private void crossBridge(Bridge bridge) {
        boolean isGameContinued = true;
        BridgeGame bridgeGame = new BridgeGame();

        for(int i = 0; i < bridge.getBridge().size(); i++) {
            outputView.printMap(bridge, bridgeGame.move(inputView.readMoving()));
        }
    }
}
