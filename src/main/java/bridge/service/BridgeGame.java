package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
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
    private final Bridge bridge;
    private final Player player;

    public BridgeGame() {
        this.bridge = new Bridge();
        this.player = new Player();
    }

    public void makeBridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge.setBridge(bridgeMaker.makeBridge(size));
    }

    public void initPlayer() {
        player.initRetryPlayer();
    }

    public boolean isClearGame() {
        return player.isClearGame(bridge);
    }

    public boolean move(String move) {
        validateMove(move);
        player.updateMoveInfo(move);
        player.setMoveResult(player.isPlayerMove(bridge));
        return player.getIsMove();
    }

    private void validateMove(String move) {
        if (!(move.equals(UP) || move.equals(DOWN))) {
            throw new MoveValueException(UP, DOWN);
        }
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
