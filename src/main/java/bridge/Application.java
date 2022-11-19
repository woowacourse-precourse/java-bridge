package bridge;

import java.awt.font.OpenType;

public class Application {
    private static final InputView inputView = new InputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        int size = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size), size);
        OutputView outputView = new OutputView(bridge);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        playGame(bridge, bridgeGame, outputView);
        outputView.printResult();
    }

    private static void playGame(Bridge bridge, BridgeGame bridgeGame, OutputView outputView) {
        while (!bridge.getGameResult()) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap();
            if (!bridge.getCorrect() && !bridgeGame.retry(inputView.readGameCommand())) {
                break;
            }
        }
    }
}
