package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;

    public BridgeGame(int size) {
        bridge = initBridge(size);
    }

    public Bridge initBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return Bridge.initBridge(bridgeMaker.makeBridge(size));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
    }
}
