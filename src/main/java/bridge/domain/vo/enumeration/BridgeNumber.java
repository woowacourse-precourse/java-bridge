package bridge.domain.vo.enumeration;

public enum BridgeNumber {
    UP_NUMBER(1),
    DOWN_NUMBER(0);

    private final int bridgeNumber;

    BridgeNumber(int bridgeNumber){
        this.bridgeNumber = bridgeNumber;
    }

    public int getBridgeNumber(){
        return this.bridgeNumber;
    }
}
