package bridge.Game;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * (추가) inputview, outputview를 사용하지 않는다.
 */
public class BridgeGame {

    private Bridge bridge;

    public void start() {
        this.bridge = new Bridge();
        move();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move() {
        boolean movable = bridge.isNotArrived();
        while (movable) {
            boolean passable = bridge.passBridge();

            if (!passable) {
                movable = retry();
                continue;
            }

            movable = bridge.isNotArrived();
        }
        endGame();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean retry() {
        return bridge.retryPassBridge();
    }

    private void endGame() {
        bridge.showResult();
    }
}
