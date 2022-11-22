package bridge.exception;

public class BridgeSizeException extends IllegalArgumentException{
    private final BridgeGameError bridgeGameError;

    public BridgeSizeException(BridgeGameError bridgeGameError) {
        this.bridgeGameError = bridgeGameError;
    }

    public void printErrorMessage() {
        System.out.println(bridgeGameError.getErrorMessage());
    }
}
