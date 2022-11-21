package bridge.domain.operator;

import bridge.controller.GameStatus;
import bridge.domain.bridge.Bridge;
import bridge.domain.player.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Player player;
    private final GameStatus gameStatus;
    private final BridgeResult bridgeResult;

    public BridgeGame(Bridge bridge, Player player, GameStatus gameStatus) {
        this.bridge = bridge;
        this.player = player;
        this.gameStatus = gameStatus;
        this.bridgeResult = new BridgeResult();
    }

    public BridgeResult getBridgeResult() {
        return bridgeResult;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userSelection) {
        int playerLocation = player.getPlayerLocation();
        boolean passable = bridge.isPassable(playerLocation, userSelection);

        bridgeResult.addResult(passable, playerLocation, userSelection);
        handleAfterMove(passable);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeResult.resetBridgeResult();
        player.resetPlayerLocation();
        player.setCross(true);
        gameStatus.plusAttempt();
    }

    private void handleAfterMove(boolean passable) {
        if (!passable) {
            player.setCross(false);
            gameStatus.setSuccess(false);
            return;
        }
        player.movePlayerLocation();
        player.setCross(true);
    }

    public boolean isClear() {
        if (player.getPlayerLocation() >= bridge.getBridge().size()) {
            player.setCross(false);
            gameStatus.setSuccess(true);
            return true;
        }
        return false;
    }
}
