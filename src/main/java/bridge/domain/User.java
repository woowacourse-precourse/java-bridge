package bridge.domain;

public class User {

    private String nextStep; // 유저가 선택한 다음 위치
    private int currentBridge = 0; // 유저가 현재 위치한 다리 위치

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public int getCurrentBridge() {
        return currentBridge;
    }

    public void goBackToFirstBridge() {
        this.currentBridge = 0;
    }

    public void moveNextBridge() {
        this.currentBridge += 1;
    }

}
