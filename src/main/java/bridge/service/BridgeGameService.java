package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import java.util.List;

public class BridgeGameService {

    private final BridgeMaker bridgeMaker;

    public BridgeGameService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public BridgeGame bridgeGame(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Player player = new Player();

        return new BridgeGame(bridge, player);
    }
}
