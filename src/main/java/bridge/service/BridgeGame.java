package bridge.service;

import bridge.GameResult;
import bridge.model.Bridge;
import bridge.model.DrawType;
import bridge.model.GameCommand;
import bridge.model.GameMap;
import bridge.model.GameState;
import bridge.model.Moving;
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
    public void move(Moving moving) {
        player.move();
        changeStateByPlayerLife(player.die(bridge, moving));
        drawGameMapBySurvival(player.die(bridge, moving), moving);
    }

    private void changeStateByPlayerLife(boolean isPlayerDied) {
        if (isPlayerDied) {
            setState(GameState.FAIL);
            return;
        }
        if (player.isBridgePassed(bridge)) {
            setState(GameState.SUCCESS);
        }
    }

    private void drawGameMapBySurvival(boolean isPlayerDied, Moving moving) {
        if (isPlayerDied) {
            gameMap.draw(moving, DrawType.FAIL);
            return;
        }
        gameMap.draw(moving, DrawType.SUCCESS);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(GameCommand command) {
        if (command == GameCommand.QUIT) {
            setState(GameState.QUIT);
            return;
        }
        initialize();
    }

    public GameResult gameResult() {
        return new GameResult(state == GameState.SUCCESS, player.getTryCount());
    }

    public boolean fail() {
        return state == GameState.FAIL;
    }

    public boolean quit() {
        return state == GameState.SUCCESS || state == GameState.QUIT;
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
