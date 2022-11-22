package bridge;

import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.DrawType;
import bridge.model.GameCommand;
import bridge.model.GameMap;
import bridge.model.GameState;
import bridge.model.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Player player;
    private final GameMap gameMap;
    private GameState state;

    public BridgeGame(Bridge bridge, Player player, GameMap gameMap) {
        this.bridge = bridge;
        this.player = player;
        this.gameMap = gameMap;
        setState(GameState.PLAYING);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        player.move();
        changeStateByPlayerLife(player.die(bridge, direction));
        drawGameMapBySurvival(player.die(bridge, direction), direction);
    }

    private void changeStateByPlayerLife(boolean playerDie) {
        if (playerDie) {
            setState(GameState.FAIL);
            return;
        }
        if (player.isBridgePassed(bridge)) {
            setState(GameState.COMPLETE);
        }
    }

    private void drawGameMapBySurvival(boolean playerDie, Direction direction) {
        if (playerDie) {
            gameMap.draw(direction, DrawType.FAIL);
            return;
        }
        gameMap.draw(direction, DrawType.SUCCESS);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(GameCommand command) {
        if (command == GameCommand.QUIT) {
            setState(GameState.FAIL_QUIT);
            return;
        }
        initialize();
    }

    public GameResult gameResult() {
        return new GameResult(state == GameState.COMPLETE, player.getTryCount());
    }

    public boolean end() {
        return state == GameState.FAIL;
    }

    public boolean quit() {
        return state == GameState.COMPLETE || state == GameState.FAIL_QUIT;
    }

    public String getGameMap() {
        return gameMap.toString();
    }

    private void initialize() {
        player.initialize();
        gameMap.initialize();
        setState(GameState.PLAYING);
    }

    private void setState(GameState state) {
        this.state = state;
    }
}
