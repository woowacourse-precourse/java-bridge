package domain;

public class Result {
    private boolean isSuccess;

    private int trial;

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public int getTrial() {
        return trial;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void setTrial(int trial) {
        this.trial = trial;
    }

    public void setResult(boolean isSuccess, int trial){
        this.isSuccess = isSuccess;
        this.trial = trial;
    }
}
