package bridge.domain.enumeration;

public enum BridgeNumber {
    UP_NUMBER(1),
    DOWN_NUMBER(1);

    private final int bridgeNumber;

    BridgeNumber(int bridgeNumber){
        this.bridgeNumber = bridgeNumber;
    }

    public int getBridgeNumber(){
        return this.bridgeNumber;
    }
}
