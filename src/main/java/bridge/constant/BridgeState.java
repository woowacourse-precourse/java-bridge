package bridge.constant;

public enum BridgeState {
    UP(1,"U"),
    DOWN(0, "D");

    private final int numberBridgeState;
    private final String bridgeState;

    BridgeState(int numberBridgeState, String bridgeState){
        this.numberBridgeState=numberBridgeState;
        this.bridgeState=bridgeState;
    }





}
