package bridge.business.enumeration;

public enum BridgeLength {
    MAX(20), MIN(3);

    private final int value;

    BridgeLength(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
