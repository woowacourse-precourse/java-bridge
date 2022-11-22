package bridge.domain;

public class User {
    private boolean isDone;
    private boolean isSuccess;
    private int trial;

    public User() {
        this.trial = 1;
        this.isDone = false;
        this.isSuccess = false;
    }

    public int getTrial(){
        return trial;
    }

    public void retry(){
        trial++;
    }

    public void winGame(){
        isDone = true;
        isSuccess = true;
    }

    public void loseGame(){
        isDone = true;
        isSuccess = false;
    }

    public boolean isGameDone(){
        return isDone;
    }

    public boolean isSuccessful(){
        return isSuccess;
    }
}
