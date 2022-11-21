package bridge.service;

import bridge.domain.BridgeMaker;
import bridge.domain.Player;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.dto.Bridge;
import bridge.dto.MoveResult;
import bridge.repository.PlayerRepository;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final PlayerRepository playerRepository;

    public BridgeGame() {
        playerRepository = new PlayerRepository();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(Long playerId, Bridge bridge, String position) {
        Player player = playerRepository.findById(playerId);
        player.movePosition(bridge, position);
        playerRepository.update(playerId, player);
        return new MoveResult(player.isGameOver(bridge));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public Bridge generateBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        return bridge;
    }

    public Long generatePlayer() {
        return playerRepository.insert(new Player());
    }
}
