package bridge.model;

public class BridgeGameStage {

    private final String bridgeBlock;
    private Status status;

    public BridgeGameStage(String bridgeBlock) {
        this.bridgeBlock = bridgeBlock;
        this.status = Status.NOT_REACHED;
    }

    public String getBridgeBlock() {
        return bridgeBlock;
    }

    public Status getStatus() {
        return status;
    }

    public void initStatus() {
        status = Status.NOT_REACHED;
    }

    public void crossBlock() {
        status = Status.CROSSED;
    }

    public void notCrossBlock() {
        status = Status.NOT_CROSSED;
    }
}
