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
        BridgeGame bridgeGame = new BridgeGame();
        boolean isSuccess = false;
        int tryCount = 1;

        while (true) {
            int bridgeIdx = 0;

            while (bridgeIdx < bridgeSize) {
                boolean isMoved =
                        bridgeGame.move(inputView.readMoving(), bridge.get(bridgeIdx));
                outputView.printMap(bridgeGame.bridgeMapToString());

                if (!isMoved) {
                    break;
                }

                bridgeIdx++;
            }

            if (bridgeIdx != bridgeSize &&
                    bridgeGame.retry(inputView.readGameCommand())) {
                tryCount++;
                continue;
            }

            if (bridgeIdx == bridgeSize) {
                isSuccess = true;
            }

            break;
        }

        outputView.printResult(bridgeGame.gameResultToString(isSuccess, tryCount));
    }
}
