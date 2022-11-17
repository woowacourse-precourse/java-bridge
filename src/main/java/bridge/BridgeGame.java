package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int size;
    private int stepNumber;
    private List<String> bridge;
    private final BridgeMaker bridgeMaker;

    public BridgeGame(int size, BridgeMaker bridgeMaker) {
        this.size = size;
        this.bridgeMaker = bridgeMaker;
    }

    public int getSize() {
        return this.size;
    }

    public int getStepNumber() {
        return this.stepNumber;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public void initializeBridgeGame() {
        this.stepNumber = 0;
        this.bridge = this.bridgeMaker.makeBridge(this.size);
    }

    public boolean stepCheck(String userInput) {
        if (this.bridge.get(stepNumber).equals(userInput)) {
            stepNumber++;
            return true;
        }
        return false;
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
