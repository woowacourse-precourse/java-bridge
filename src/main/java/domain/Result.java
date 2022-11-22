package domain;

import enums.ResultMessage;

public class Result {
    private String isSuccess = ResultMessage.FAIL.getText();

    private int trial;

    public String getIsSuccess() {
        return isSuccess;
    }

    public int getTrial() {
        return trial;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void setTrial(int trial) {
        this.trial = trial;
    }

    public void setResult(String isSuccess, int trial){
        this.isSuccess = isSuccess;
        this.trial = trial;
    }
}
