package bridge.domain;

import bridge.domain.constants.BridgeConstants;
import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.GameCommand;
import bridge.domain.vo.Moving;
import bridge.domain.vo.PlayerMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMap bridgeMap;
    private PlayerMap playerMap;
    private boolean isMoveSuccess;
    private int count;

    private BridgeGame(BridgeMap bridgeMap) {
        this.bridgeMap = bridgeMap;
        this.playerMap = new PlayerMap();
        this.isMoveSuccess = true;
        this.count = 1;
    }

    public static BridgeGame from(BridgeMap bridgeMap) {
        return new BridgeGame(bridgeMap);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Moving moving) {
        isMoveSuccess = bridgeMap.isMovingCompare(playerMap, moving);
        playerMap.move(moving, isMoveSuccess);
        return isMoveSuccess;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(GameCommand gameCommand) {
        if (gameCommand.equals(BridgeConstants.BRIDGE_GAME_COMMAND_RETRY)) {
            playerMap = new PlayerMap();
            isMoveSuccess = true;
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public String getStatus() {
        if (isMoveSuccess) {
            return BridgeConstants.BRIDGE_GAME_SUCCESS;
        }
        return BridgeConstants.BRIDGE_GAME_FAIL;
    }

    public List<List> getPlayerMap() {
        return playerMap.getDetail();
    }

    public boolean isEnd() {
        return !isMoveSuccess || bridgeMap.isCompareSize(playerMap);
    }
}
