package bridge.domain;

public class BridgeGame {
    public Bridge bridge;
    public gameStatus currentStatus;

    public void move(String direction) {
        gameStatus moveResult = bridge.updateUserRoute(direction);
        this.currentStatus = moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
