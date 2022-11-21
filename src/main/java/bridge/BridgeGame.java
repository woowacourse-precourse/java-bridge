package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * 필드 추가 가능
 * 패키지 변경 가능
 * 매서드 이름 변경 불가능, 인자와 반환타입은 추가 변경 가능
 * 매서드 추가 변경 가능
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction, int targetBlock, List<String> bridge) {
        return direction.equals(bridge.get(targetBlock));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
