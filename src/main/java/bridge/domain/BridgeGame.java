package bridge.domain;

import bridge.model.Bridge;
import bridge.model.BridgeMap;
import bridge.model.Player;

import static bridge.util.BridgeConstant.CONTINUE_GAME;
import static bridge.util.BridgeConstant.QUIT_GAME;
import static bridge.util.BridgeConstant.GAME_RETRY_KEY;
import static bridge.util.BridgeConstant.FALL_BLOCK;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param player
     */
    public void move(Player player, String moveTo) {
        player.setPosition(moveTo);
    }

    public boolean check(Player player, Bridge bridge) {
        boolean moveSuccess = getMoveSuccess(player, bridge);
        addBlockCurrentBridgeMap(player, moveSuccess);
        return moveSuccess;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(Player player, String continueCode) {
        boolean continueCommand = getContinueCode(player, continueCode);
        if (continueCommand == CONTINUE_GAME) {
            return true;
        }
        return false;
    }

    public boolean judge(Player player, Bridge bridge) {
        if (getReachFinalLine(player, bridge) && getMoveSuccess(player, bridge)) {
            return true;
        }
        return false;
    }

    private boolean getReachFinalLine(Player player, Bridge bridge) {
        return player.getXPosition() == bridge.getBridge()[0].length - 1;
    }

    private boolean getMoveSuccess(Player player, Bridge bridge) {
        int positionX = player.getXPosition();
        int positionY = player.getYPosition();
        return !bridge.getBridge()[positionY][positionX].equals(FALL_BLOCK);
    }


    public boolean getContinueCode(Player player, String continueCode) {
        if (continueCode.equals(GAME_RETRY_KEY)) {
            updateGameStatus(player);
            return CONTINUE_GAME;
        }
        return QUIT_GAME;
    }

    private void updateGameStatus(Player player) {
        player.initializePosition();
        player.addTryCount();
        BridgeMap.getBridgeMap().initializeBridges();
    }

    private void addBlockCurrentBridgeMap(Player player, boolean moveSuccess) {
        new BridgeMapMaker().addBlockBridgeMap(player, moveSuccess);
    }
}