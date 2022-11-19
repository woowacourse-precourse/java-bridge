package bridge;

import bridge.domain.BridgeStatus;
import java.util.List;

public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final BridgeStatusSaver bridgeStatusSaver;

    public BridgeGame(BridgeMaker bridgeMaker, BridgeStatusSaver bridgeStatusSaver) {
        this.bridgeMaker = bridgeMaker;
        this.bridgeStatusSaver = bridgeStatusSaver;
    }

    public void createBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(bridge);
        bridgeStatusSaver.setBridgeStatus(bridgeStatus);
    }

    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
