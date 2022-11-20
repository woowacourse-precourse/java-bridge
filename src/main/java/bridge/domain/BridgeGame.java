package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int START_POSITION = 0;
    private final List<String> bridge;
    private int position;

    public BridgeGame(BridgeMaker bridgeMaker, int size) {
        bridge = bridgeMaker.makeBridge(size);
        position = START_POSITION;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        position = position + 1;
    }

    public boolean isClear(Moving moving) {
        return isSafe(moving)
                && position == bridge.size();
    }

    public boolean isDead(Moving moving) {
        return !bridge.get(position-1).equals(moving.name());
    }

    public boolean isSafe(Moving moving) {
        return bridge.get(position-1).equals(moving.name());
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        position = START_POSITION;
    }
}
