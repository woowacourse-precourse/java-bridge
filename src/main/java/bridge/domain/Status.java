package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Status {

    private int successedPhase;
    private int totalTryNumber;
    private boolean isSuccess;

    public Status() {
        this.successedPhase = 0;
        this.totalTryNumber = 0;
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

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public int getSuccessedPhase() {
        return successedPhase;
    }

    public void increaseSuccessedPhase() {
        this.successedPhase++;
    }
}
