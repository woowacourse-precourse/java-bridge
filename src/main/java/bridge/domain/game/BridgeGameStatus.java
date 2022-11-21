package bridge.domain.game;

public enum BridgeGameStatus {
    TRYING(false, "시도"),
    SUCCESS(true, "성공"),
    FAILURE(false, "실패"),
    ;
    
    private final boolean isSuccess;
    private final String outputText;
    
    BridgeGameStatus(boolean isSuccess, String outputText) {
        this.isSuccess = isSuccess;
        this.outputText = outputText;
    }
    
    public boolean isSuccess() {
        return isSuccess;
    }
    
    public String getOutputText() {
        return outputText;
    }
}
