package bridge.model;

import bridge.util.ResultConstant;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int count;

    public BridgeGame() {
        count = 1;
    }

    public void initialize(Record record) {
        record.clearRecord();
        record.putInResultBoard(ResultConstant.SUCCESS_OR_FAIL, null);
        record.putInResultBoard(ResultConstant.NUMBER_OF_ATTEMPTS, count);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Record record, String direction) {
        record.addInBoard(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(Record record, String retryOrQuit) {
        if (RetryCommand.equals(retryOrQuit, RetryCommand.RETRY)) {
            count++;
            initialize(record);
            return true;
        }
        return false;
    }

    public int isSuccess(Record record, List<String> bridge) {
        int boardIndex = record.getBoardSize() - 1;
        int bridgeIndex = bridge.size() - 1;

        if ((boardIndex == bridgeIndex) &&
                record.equalsToBoard(boardIndex, bridge.get(bridgeIndex))) {
            return 1;  //성공
        }
        return 0;  //실패
    }
}
