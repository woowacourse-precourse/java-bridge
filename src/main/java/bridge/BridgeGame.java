package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static List<String> bridge;
    private static List<Integer> record;
    private static int trial;
    private static String success;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<Integer> move(String choice) {
        int currentPosition = record.size();
        int stateCode = getStateCode(currentPosition, choice);
        record.add(stateCode);
        return record;
    }

    private int getStateCode(int position, String choice) throws IllegalArgumentException {
        String state = bridge.get(position) + choice;
        for (StateCode stateCode : StateCode.values()) {
            if (state.equals(stateCode.getState())) {
                return stateCode.getCode();
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 상태 - U 또는 D만 입력되어야함");
    }

    public boolean checkComplete() {
        if (record.size() == bridge.size() && !hasFail()) {
            success = "성공";
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            this.record = new ArrayList<>();
            this.trial += 1;
            return true;
        }
        return false;
    }

    public void initialize(List<String> bridge) {
        this.bridge = bridge;
        this.record = new ArrayList<>();
        this.trial = 1;
        this.success = "실패";
    }

    public boolean hasFail() {
        if (record.contains(2) || record.contains(3)) {
            return true;
        }
        return false;
    }

    public List<Integer> getRecord() {
        return record;
    }

    public String getSuccess() {
        return success;
    }

    public int getTrial() {
        return trial;
    }
}
