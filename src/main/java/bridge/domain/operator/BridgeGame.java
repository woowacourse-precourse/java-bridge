package bridge.domain.operator;

import bridge.domain.bridge.Bridge;
import bridge.domain.player.Player;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Player player;
    private final BridgeResult bridgeResult;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
        this.bridgeResult = new BridgeResult();
    }

    public List<Boolean> getUpBridgeResult() {
        return bridgeResult.getUpBridge();
    }

    public List<Boolean> getDownBridgeResult() {
        return bridgeResult.getDownBridge();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userSelection) {
        boolean passable = bridge.isPassable(player.getPlayerLocation(), userSelection);
        bridgeResult.addResult(passable, player.getPlayerLocation(), userSelection);
        if (!passable) {
            player.resetPlayerLocation();
        }
        player.movePlayerLocation();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
