package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static bridge.domain.Moving.UP;
import static bridge.domain.Result.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private List<Result> results = new ArrayList<>();
    private int tryCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int index, String moving) {
        if (bridge.get(index).equals(moving)) {
            return addSuccess(index);
        }
        return addFail(index);
    }

    private boolean addSuccess(int index) {
        if (bridge.get(index).equals(UP.getMoving())) {
            return addResult(UP_SUCCESS);
        }
        return addResult(DOWN_SUCCESS);
    }

    private boolean addFail(int index) {
        if (bridge.get(index).equals(UP.getMoving())) {
            return addResult(UP_FAIL);
        }
        return addResult(DOWN_FAIL);
    }

    private boolean addResult(Result result) {
        results.add(result);
        if (result == UP_SUCCESS || result == DOWN_SUCCESS) {
            return true;
        }
        return false;
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        results.clear();
        tryCount += 1;
    }

    public int getTryCount() {
        return tryCount;
    }
}
