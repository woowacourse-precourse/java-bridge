package bridge;

import java.util.List;

public class BridgeGame {
    private int size;
    private boolean[] stepStatus;
    private int stepNumber;
    private int tryNumber;
    private List<String> bridge;
    private final BridgeMaker bridgeMaker;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public boolean getStepStatus(int idx) {
        return this.stepStatus[idx];
    }

    public int getStepNumber() {
        return this.stepNumber;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public void initializeBridgeGame(int size) {
        this.stepNumber = 0;
        this.stepStatus = new boolean[size];
        this.tryNumber = 1;
        this.size = size;
        this.bridge = this.bridgeMaker.makeBridge(this.size);
    }

    public boolean terminateCheck() {
        return (this.size == this.stepNumber) && (this.stepStatus[this.size - 1]);
    }

    public void retry() {
        this.stepNumber = 0;
        this.stepStatus = new boolean[this.size];
        this.tryNumber++;
    }

    public boolean move(String userInput) {
        if (this.bridge.get(this.stepNumber).equals(userInput)) {
            this.stepStatus[this.stepNumber] = true;
            this.stepNumber++;
            return true;
        }
        this.stepNumber++;
        return false;
    }
}
