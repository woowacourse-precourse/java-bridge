package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import java.util.List;

public class BridgeService {
    private final ViewService viewService = new ViewService();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public BridgeGame bridgeGameMaker() {
        int bridgeSize = askBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(makeBridgeGame(bridgeSize));
        return bridgeGame;
    }

    public int askBridgeSize() {
        int bridgeSize = viewService.requestBridgeSize();
        return bridgeSize;
    }

    public List<String> makeBridgeGame(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }
}
