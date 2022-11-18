package bridge.service;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputService inputService = new InputService();

    // 여기서 View를 쓰면 안됨!
    // 메서드 이름은 변경하면 안됨! / 인자와 반환은 추가 및 변경 가능
    // 메서드 추가 가능

    public void gameStart() {
        inputService.printGameStart();
    }

    public int getBridgeSize() {
        return inputService.requestBridgeSize();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
