package bridge.model.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.domain.BridgeGame;
import java.util.List;

public class BridgeService {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

    public void createBridge(int bridgeSize) {
        List<String> bridgesSign = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridgesSign);
    }
}
