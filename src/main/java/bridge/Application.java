package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        inputView.startMsg();

        int bridgeSize = inputView.readBridgeSize();

        List<String> firstBridge = bridgeMaker.makeBridge(bridgeSize);
        List<String> secondBridge = bridgeMaker.makeSecondBridge(firstBridge);

        for (int i = 0; i < bridgeSize; i++) {
            String move = inputView.readMoving();
            String[] bridgeMap = bridgeGame.move(firstBridge, secondBridge, move);
            outputView.printMap(bridgeMap);
            i = bridgeGame.count(i, bridgeSize);
        }

        outputView.printResult();

    }
}
