package bridge.controller;

import bridge.domain.Status;
import bridge.service.BridgeGameService;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private final BridgeGameService bridgeGameService;
    private int attempt = 0;

    public BridgeGame() {
        bridgeGameService = new BridgeGameService();
    }

    public void start() {
        bridge = bridgeGameService.initializeGame();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * @return Status
     */
    public Status move() {
        return bridgeGameService.proceedGame(bridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
