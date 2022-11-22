package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Move;
import bridge.domain.MoveResult;
import bridge.domain.Player;

public class BridgeGame {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final Player player = new Player();
    private Bridge bridge;

    public void createBridge(int bridgeSize) {
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Move moveTo) {
        return player.move(bridge, moveTo) == MoveResult.SUCCESS;
    }

    public boolean isClear() {
        return bridge.isFinish(player.getMoveDistance());
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player.newLife();
    }
}
