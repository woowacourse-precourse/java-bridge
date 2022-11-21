package bridge.domain;

import java.util.*;

import static bridge.domain.ConstantMessage.GAME_RESULT_SUCCESS_OR_FAIL_MESSAGE;
import static bridge.domain.ConstantMessage.GAME_RETRY_COUNT_MESSAGE;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int bridgeLength;
    private boolean isPlayerMoveSuccess;
    private boolean isSuccessGame;
    private int bridgeIdx;
    private int tryCount;
    private List<String> bridge;
    private List<String> playerMoveRecord;
    private List<MoveAnswer> playerMoveWhetherAnswer;
    private StringBuilder printPlayerMoveUp;
    private StringBuilder printPlayerMoveDown;
    private List<StringBuilder> printPlayerMove;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveDirection , int bridgeIdx) {
        playerMoveRecord.add(moveDirection);
        if(bridge.get(bridgeIdx).equals(moveDirection)) {
            isPlayerMoveSuccess = true;
            return;
        }
        isPlayerMoveSuccess = false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
    
    public void setBridgeLength(int bridgeLength) {
        this.bridgeLength = bridgeLength;
    }

    public int getBridgeLength() {
        return bridgeLength;
    }

    public int getBridgeSize(){
        return bridge.size();
    }

    public int getBridgeIdx() {
        return bridgeIdx;
    }

    public BridgeGame(int bridgeLength, int tryCount) {
        this.bridgeLength = bridgeLength;
        this.tryCount = tryCount;
    }
}
