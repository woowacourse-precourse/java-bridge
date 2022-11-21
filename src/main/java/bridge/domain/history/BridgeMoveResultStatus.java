package bridge.domain.history;

public enum BridgeMoveResultStatus {
    SUCCESS(true, " O "),
    FAILURE(false, " X ");
    
    private final boolean isMoved;
    private final String output;
    
    BridgeMoveResultStatus(boolean isMoved, String output) {
        this.isMoved = isMoved;
        this.output = output;
    }
    
    public boolean isMoved() {
        return isMoved;
    }
    
    public String getOutput() {
        return output;
    }
}
