package bridge.constant;

public enum BridgeRetryCommand {
    RETRY("R"),
    QUIT("Q");

    public final String command;
    BridgeRetryCommand(String command){
        this.command = command;
    }
}
