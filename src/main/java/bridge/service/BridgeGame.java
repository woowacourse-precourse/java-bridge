package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.BridgeState;
import bridge.domain.Bridges;
import bridge.exception.NotFoundBridgeException;
import bridge.exception.NotFoundBridgeStateException;
import bridge.service.dto.BridgeSizeDto;
import bridge.service.dto.BridgeSpaceDto;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final Bridges bridges;

    public BridgeGame(BridgeMaker bridgeMaker, Bridges bridges) {
        this.bridgeMaker = bridgeMaker;
        this.bridges = bridges;
    }

    public void create(BridgeSizeDto dto) {
        List<String> createdBridges = bridgeMaker.makeBridge(dto.getBridgeSize());
        bridges.generate(createdBridges);
    }

    public boolean isCrossAllBridges() {
        return bridges.isCrossAllBridges();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(BridgeSpaceDto dto) {
        BridgeState bridgeState = BridgeState.findByPlayerValue(dto.getMovingSpace())
                .orElseThrow(NotFoundBridgeStateException::new);

        Bridge bridge = bridges.findBridgeByNotCrossed()
                .orElseThrow(NotFoundBridgeException::new);


    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
