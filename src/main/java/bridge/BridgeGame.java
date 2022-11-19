package bridge;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final boolean CORRECT_BRIDGE = true;
    private static final boolean WRONG_BRIDGE = false;

    private List<Boolean> movingResult = new LinkedList<>();

    private int tryCount = 1;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, String moving) {
        if(moving.equals(bridge.get(movingResult.size()))) {
            movingResult.add(CORRECT_BRIDGE);
            return CORRECT_BRIDGE;
        }
        
        movingResult.add(WRONG_BRIDGE);
        return WRONG_BRIDGE;
    }

    public List<Boolean> getMovingResult() {
        return movingResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        movingResult = new LinkedList<>();
    }
}
