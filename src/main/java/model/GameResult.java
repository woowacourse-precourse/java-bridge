package model;

public class GameResult {

    private int retry;

    private boolean success;

    public GameResult() {
        retry = 1;
        success = false;
    }

    public int getRetry() {
        return retry;
    }

    public String isSuccess() {
        if(success == true)
            return "성공";
        return "실패";
    }

    public void addRetry() {
        retry+=1;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
