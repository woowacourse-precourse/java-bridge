package model;

public class GameResult {

    private int retry;

    private boolean success;

    public int getRetry() {
        return retry;
    }

    public String isSuccess() {
        if(success == true)
            return "성공";
        return "실패";
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
