package bridge.domain;

import bridge.controller.GameState;
import bridge.domain.object.Bridge;
import bridge.domain.object.Player;

import java.util.List;

import static bridge.controller.GameState.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Player player;
    private final Bridge bridge;
    private GameState state;
    private int tryCount;

    public BridgeGame(Player player, Bridge bridge) {
        this.player = player;
        this.bridge = bridge;
        this.state = RUN;
        this.tryCount = 1;
    }

    public void move(final String moving) {
        player.addMove(moving);
    }

    public void retry() {
        this.player = new Player();
        this.state = RUN;
        this.tryCount += 1;
    }

    public GameState checkGameState() {
        checkClear();
        checkFail();
        return this.state;
    }

    private void checkClear() {
        List<String> moves = player.getMoves();
        if (bridge.checkCorrectRoute(moves)) {
            this.state = CLEAR;
        }
    }

    private void checkFail() {
        List<String> moves = player.getMoves();
        if (bridge.checkDifferentRoute(moves)) {
            this.state = FAIL;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public GameState getState() {
        return state;
    }

    public int getTryCount() {
        return tryCount;
    }
}
