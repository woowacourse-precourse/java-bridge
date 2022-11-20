package bridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String UPSIDE = "U";
    private static final String DOWNSIDE = "D";
    private static final String MOVE_SUCCESS_RECORD = "O";
    private static final String MOVE_FAILURE_RECORD = "X";
    private static final String BLANK_RECORD = " ";

    private List<String> bridge;
    private int nowIndex;
    private Map<String, List<String>> records;
    private int trials;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.nowIndex = 0;
        this.records = Map.of(
                UPSIDE, new ArrayList<>(),
                DOWNSIDE, new ArrayList<>()
        );
        this.trials = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        if (bridge.get(nowIndex).equals(moving)) {
            nowIndex++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        nowIndex = 0;
        records = Map.of(
                UPSIDE, new ArrayList<>(),
                DOWNSIDE, new ArrayList<>()
        );
        trials++;
    }

    public void updateRecords(String moving, boolean moveSuccess) {
        String record = judgeRecord(moveSuccess);
        records.get(moving).add(record);

        String another = judgeAnotherDirection(moving);
        records.get(another).add(BLANK_RECORD);
    }

    private String judgeAnotherDirection(String moving) {
        if (moving.equals(UPSIDE)) {
            return DOWNSIDE;
        }
        return UPSIDE;
    }

    private String judgeRecord(boolean moveSuccess) {
        if (moveSuccess) {
            return MOVE_SUCCESS_RECORD;
        }
        return MOVE_FAILURE_RECORD;
    }

    public List<String> getRecords(String direction) {
        return records.get(direction);
    }

    public int getTrials() {
        return trials;
    }

    public boolean isArrived() {
        return bridge.size() == nowIndex;
    }
}