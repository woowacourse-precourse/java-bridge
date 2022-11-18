package bridge.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.map.Map;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int currentPosition;
    private int totalTry;
    private Map map;

    BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        currentPosition = 0;
        totalTry = 1;
        map = new Map();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(String moving) {
        if (canMove(moving)) {
            if (currentPosition == bridge.size() - 1) {
                return Status.SUCCESS.getNumber();
            }
            currentPosition++;
            return Status.CONTINUE.getNumber();
        }
        return Status.FAIL.getNumber();
    }

    private boolean canMove(String moving) {
        String bridgeStatus = bridge.get(currentPosition);
        if (bridgeStatus.equals(moving)) {
            map.addCanCross(moving);
            return true;
        }
        map.addCanNotCross(moving);
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        currentPosition = 0;
        totalTry++;
        map = new Map();
    }
}
