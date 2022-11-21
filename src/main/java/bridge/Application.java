package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        String moveTarget = inputView.readMoving();
        List<String> result = new ArrayList<>();
        BridgeGame bridgeGame = new BridgeGame();
        result.add(bridgeGame.move(moveTarget, bridge, result.size()));
        // TODO: 프로그램 구현
    }
}
