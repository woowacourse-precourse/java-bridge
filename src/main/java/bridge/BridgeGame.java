package bridge;

import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private JudgeMovingResult judgeMovingResult = new JudgeMovingResult();
    private ResultRepository resultRepositiory;
    private List<String> bridge;
    private int numberOfAttempt;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.resultRepositiory = new ResultRepository();
        this.numberOfAttempt = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(int numberOfMoving, String moving) {
        String movingResult = judgeMovingResult.isMovingPossible(moving, bridge.get(numberOfMoving - 1));

        Map<String, String> movingRecord = judgeMovingResult.recordMoving(moving, movingResult);
        resultRepositiory.saveCumulativeResult(movingRecord, numberOfMoving);

        return movingResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        numberOfAttempt++;
        this.resultRepositiory = new ResultRepository();
    }

}
