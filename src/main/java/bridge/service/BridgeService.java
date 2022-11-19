package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.dto.BridgeCrossingDTO;

public class BridgeService {
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private Bridge bridge;

    public BridgeService() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void createBridge(int bridgeSize) {
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        bridgeGame = new BridgeGame(bridge);
    }

    public BridgeCrossingDTO moveUser(String bridgeMoving) {
        bridgeGame.move(bridgeMoving);
        return bridgeGame.toResponseDto();
    }
}
