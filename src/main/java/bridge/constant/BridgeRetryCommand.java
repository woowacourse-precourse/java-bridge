package bridge.constant;

public enum BridgeRetryCommand {
    RETRY("R"),
    QUIT("Q");

    private String command;
    BridgeRetryCommand(String command){
        this.command = command;
    }
}
