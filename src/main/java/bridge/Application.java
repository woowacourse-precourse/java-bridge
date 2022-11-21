package bridge;

import java.util.List;

public class Application {

    private static final InputView inputView = new InputView(new BridgeValidator());
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printGameStart();
        BridgeGame bridgeGame = initBridgeGame();

        startGame(bridgeGame);
    }

    private static void startGame(BridgeGame bridgeGame) {
        for (int i = 0; i < bridgeGame.getBridge().size(); i++) {
            String direction = inputView.readMoving();
        }
    }

    private static BridgeGame initBridgeGame() {
        return new BridgeGame(makeBridge(), inputView);
    }

    private static List<String> makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        outputView.printGuideForBridgeSize();
        int bridgeSize = inputView.readBridgeSize();

        return bridgeMaker.makeBridge(bridgeSize);
    }
}
