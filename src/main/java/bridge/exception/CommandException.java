package bridge.exception;

public class CommandException extends IllegalArgumentException {

    private final BridgeGameError bridgeGameError;

    public CommandException(BridgeGameError bridgeGameError) {
        this.bridgeGameError = bridgeGameError;
    }

    public void printErrorMessage() {
        System.out.println(bridgeGameError.getErrorMessage());
    }
}
