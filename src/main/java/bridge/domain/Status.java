package bridge.domain;

import java.util.List;

public class Status {

    private List<String> crossedBridge;
    private int totalTryNumber;
    private boolean isSuccess;

    public Status(List<String> crossedBridge, int totalTryNumber, boolean isSuccess) {
        this.crossedBridge = crossedBridge;
        this.totalTryNumber = totalTryNumber;
        this.isSuccess = isSuccess;
    }

    public int getTotalTryNumber() {
        return totalTryNumber;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
