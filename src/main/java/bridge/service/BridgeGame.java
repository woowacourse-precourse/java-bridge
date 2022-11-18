package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.Bridges;
import bridge.domain.GameState;
import bridge.service.dto.request.BridgeSizeRequestDto;
import bridge.service.dto.request.PlayerMovementRequestDto;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final Bridges bridges;
    private final GameState gameState;

    public BridgeGame(BridgeMaker bridgeMaker, Bridges bridges, GameState gameState) {
        this.bridgeMaker = bridgeMaker;
        this.bridges = bridges;
        this.gameState = gameState;
    }

    public void create(BridgeSizeRequestDto dto) {
        List<String> realBridges = bridgeMaker.makeBridge(dto.getBridgeSize());
        bridges.generate(realBridges);
    }

    public boolean isGameOver() {
        return bridges.isGameClear() || gameState.isFail();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(PlayerMovementRequestDto dto) {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
