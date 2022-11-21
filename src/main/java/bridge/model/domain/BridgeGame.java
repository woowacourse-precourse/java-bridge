package bridge.model.domain;

import bridge.constant.Constant;
import bridge.model.dto.GameResultDto;
import bridge.model.dto.MoveResultDto;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridges bridges;
    private int position = Constant.BRIDGE_INITIAL_POSITION;
    private int retryCount = Constant.INITIAL_RETRY_COUNT;
    private SuccessOrFail successOrFail = SuccessOrFail.SUCCESS;

    public BridgeGame(List<String> bridgesSign) {
        this.bridges = new Bridges(bridgesSign);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResultDto move(Bridge bridgeToMove) {
        Bridge actualBridge = bridges.findBridgeByPosition(++position);
        List<Integer> bridgeMap = bridges.readBridgeMap(position);
        boolean isRightLastBridgePick = actualBridge == bridgeToMove;
        boolean isMovableStatus = position != bridges.size() - Constant.INDEX_ZEROING_NUMBER;
        return new MoveResultDto(bridgeMap, isRightLastBridgePick, isMovableStatus);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(boolean isRestartGame) {
        if (!isRestartGame) {
            successOrFail = SuccessOrFail.FAIL;
            return;
        }
        position = Constant.BRIDGE_INITIAL_POSITION;
        retryCount++;
    }

    public GameResultDto readGameResult() {
        return new GameResultDto(bridges.readBridgeMap(position), successOrFail, retryCount);
    }
}
