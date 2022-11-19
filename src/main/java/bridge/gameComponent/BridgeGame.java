package bridge.gameComponent;

import bridge.exception.ExceptionMessage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int index; //현재까지 움직인 칸
    private int endIndex; //마지막 칸
    private int numberOfTries;

    public BridgeGame(Bridge bridge) {
        if (bridge == null) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_INPUT.getMessage());
        }
        this.index = 0;
        this.endIndex = bridge.getBridge().size() - 1;
        this.numberOfTries = 1;
    }
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        index++;
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
