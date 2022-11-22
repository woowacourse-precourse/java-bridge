package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.dto.BridgeCrossingDTO;

public class BridgeService {
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeService() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void createBridge(int bridgeSize) {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        bridgeGame = new BridgeGame(bridge);
    }

    public BridgeCrossingDTO moveUser(String bridgeMoving) {
        bridgeGame.move(bridgeMoving);
        return bridgeGame.toResponseDto();
    }

    public void retryGame() {
        bridgeGame.retry();
    }
}
