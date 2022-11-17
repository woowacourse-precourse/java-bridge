package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int size;
    private int stepNumber;
    private int retryNumber;
    private List<String> bridge;
    private final BridgeMaker bridgeMaker;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public int getSize() {
        return this.size;
    }

    public int getStepNumber() {
        return this.stepNumber;
    }

    public int getRetryNumber() {
        return this.retryNumber;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public void initializeBridgeGame(int size) {
        this.stepNumber = 0;
        this.retryNumber = 0;
        this.size = size;
        this.bridge = this.bridgeMaker.makeBridge(this.size);
    }

    private boolean stepCheck(String userInput) {
        if (this.bridge.get(stepNumber).equals(userInput)) {
            stepNumber++;
            return true;
        }
        return false;
    }

    public boolean terminateCheck() {
        return this.size == this.stepNumber;
    }

    public void retry() {
        this.stepNumber = 0;
        this.retryNumber++;
    }

    public boolean move(String userInput) {
        return this.stepCheck(userInput);
    }
}
