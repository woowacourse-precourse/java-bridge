package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Status {

    private CurrentBridge currentBridge;
    private int totalTryNumber;
    private boolean isSuccess;

    public Status() {
        this.currentBridge = new CurrentBridge(new ArrayList<>());
        this.totalTryNumber = 1;
        this.isSuccess = false;
    }

    public int getTotalTryNumber() {
        return totalTryNumber;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void increaseTryNumber() {
        this.totalTryNumber++;
    }

    public void decreaseTryNumber() {
        if(this.totalTryNumber > 0) {
            this.totalTryNumber--;
        }
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }


    public void enterCommand(String command) {
        currentBridge.addCurrentCommand(command);
    }

    public void removeCommand() {
        currentBridge.removeCurrentCommand();
    }

    public String getCurrentCommand(int phase) {
        return currentBridge.getCurrentCommand(phase);
    }

    public int getCurrentPhase() {
        return currentBridge.getCurrentPhase();
    }
}
