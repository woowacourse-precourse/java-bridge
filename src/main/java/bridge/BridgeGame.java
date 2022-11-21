package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    int currentIndex = 0;
    int bridgeSize;
    List<String> bridge;

    public BridgeGame(int bridgeSize, List<String> bridge) {
        this.bridgeSize = bridgeSize;
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (!this.bridge.get(currentIndex).equals(moving)) {
            retry();
            return; // currentIndex 반환하도록 수정예정, currentIndex와 bridge를 OuputView에 전달해서 현재상태를 출력할 수 있게 할 예정
        }

        currentIndex += 1;
        System.out.println(currentIndex);
    }

    public boolean isEndGame() {
        if (this.currentIndex == this.bridgeSize) {
            return true;
        }

        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.currentIndex = 0;
    }
}
