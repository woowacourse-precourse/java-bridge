package bridge.model.entity;

public class BridgeSize {
    private int bridgeSize;
    private BridgeSize(String bridgeSize){
        validate(bridgeSize);

        this.bridgeSize = Integer.parseInt(bridgeSize);
    }

    public int getBridgeSize() {
        return this.bridgeSize;
    }

    private void validate(String bridgeSize) {
        //TODO: 유효성 검사 작성할 것
    }

    public static BridgeSize of(String bridgeSize){
        return new BridgeSize(bridgeSize);
    }
}
