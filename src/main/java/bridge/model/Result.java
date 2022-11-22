package bridge.model;

public class Result {
    private final boolean isDone;
    private final int attemptCount;
    public Result(boolean isDone, int attemptCount){
        this.isDone = isDone;
        this. attemptCount = attemptCount;
    }
    public boolean getIsDone(){
        return isDone;
    }
    
    public int getAttemptCount(){
        return attemptCount;
    }
}
