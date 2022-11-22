package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.exception.MoveValueException;
import bridge.exception.RetryValueException;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private final Player player;
    private final Bridge bridge;

    public BridgeGame(Player player, Bridge bridge) {
        this.player = player;
        this.bridge = bridge;
    }

    public void initPlayer() {
        player.initRetryPlayer();
    }

    public void move(String move) {
        validateMove(move);
        player.updateMoveInfo(move);
        isPlayerMove();
    }

    private void validateMove(String move) {
        if (!(move.equals(UP) || move.equals(DOWN))) {
            throw new MoveValueException(UP, DOWN);
        }
    }

    public boolean isClearGame() {
        return player.isClearGame(bridge);
    }

    public boolean isPlayerMove() {
        return player.isPlayerMove(bridge);
    }

    public boolean retry(String gameCommand) {
        validateRetry(gameCommand);
        return gameCommand.equals(RETRY);
    }

    private void validateRetry(String gameCommand) {
        if (!(gameCommand.equals(RETRY) || gameCommand.equals(QUIT))) {
            throw new RetryValueException(RETRY, QUIT);
        }
    }

    public Player getPlayer() {
        return player;
    }
}
