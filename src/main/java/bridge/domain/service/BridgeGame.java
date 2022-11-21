package bridge.domain.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.request.BridgeSizeRequest;
import bridge.controller.request.MoveRequest;
import bridge.domain.Bridge;
import bridge.domain.ScoreMap;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    private final Bridge bridge;

    public BridgeGame(BridgeSizeRequest request) {
        this.bridge = createBridge(request.getSize());
    }

    private Bridge createBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        return new Bridge(bridgeMaker.makeBridge(size));
    }

}
