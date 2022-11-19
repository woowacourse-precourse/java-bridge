package bridge.service;

import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.GameCondition;
import bridge.model.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Player player = new Player();

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Direction direction) {
        player.move(direction);
        bridge.validatePlayer(player);
        return !bridge.isDone(player);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(GameCondition condition) {
        if (condition == GameCondition.RESTART) {
            player.attempt();
            return true;
        }
        return false;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public Player getPlayer() {
        return player;
    }

}
