package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        List<String> result = new ArrayList<>();

        do {
            String moveTarget = inputView.readMoving();
            result.add(bridgeGame.move(moveTarget, bridge, result.size()));
            outputView.printMap(result, bridge);
        } while (result.size() == bridge.size() || !result.contains("X"));
        // TODO: 프로그램 구현
    }
}