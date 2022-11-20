package bridge.domain.bridgegame;

import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final GameMap gameMap;

    private BridgeGame(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public static BridgeGame from(HashMap<String, List<String>> gameMap) {
        return new BridgeGame(GameMap.from(gameMap));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGame move(String movingDirection, boolean movingSuccess) {
        GameMap resultGameMap = gameMap.addGameResult(movingDirection, movingSuccess);
        return new BridgeGame(resultGameMap);
    }

    public String getGameMap() {
        return gameMap.toString();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGame retry() {
        return new BridgeGame(gameMap.reset());
    }
}
