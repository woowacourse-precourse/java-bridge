package bridge;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();

        outputView.printStartMessage();

        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        int bridgeIdx = 0;
        BridgeGame bridgeGame = new BridgeGame();

        while (bridgeIdx < bridgeSize) {
            boolean isMoved =
                    bridgeGame.move(inputView.readMoving(), bridge.get(bridgeIdx));

            outputView.printMap(bridgeGame.bridgeMapToString());

            if (!isMoved) {
                break;
            }

            bridgeIdx++;
        }
    }
}
