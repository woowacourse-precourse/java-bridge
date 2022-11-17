package bridge.domain;

public enum MoveResult {
    SUCCESS, FAIL;
    
    public boolean isSuccess() {
        return this == SUCCESS;
    }
}
