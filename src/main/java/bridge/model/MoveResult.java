package bridge.model;

public enum MoveResult {
    SUCCESS, FAIL;

    public boolean isFailed(){
        return this == FAIL;
    }
}
