package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import java.util.List;

public class BridgeService {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public BridgeGame bridgeMaker(InputView inputView) {
        BridgeGame bridgeGame = new BridgeGame(createBridgeSize(inputView.readBridgeSize()));
        return bridgeGame;
    }

    public List<String> createBridgeSize(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }

}
