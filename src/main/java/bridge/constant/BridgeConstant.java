package bridge.constant;

public enum BridgeConstant {
    CAN_GO_UP(1,"U"), CAN_GO_DOWN(0,"D"),
    RETRY("R"), END("Q");
    int intValue;
    String stringValue;
    BridgeConstant(String stringValue){
        this.stringValue = stringValue;
    }
    BridgeConstant(int intValue, String stringValue){
        this.intValue = intValue;
        this.stringValue = stringValue;
    }
    public int getInt(){
        return intValue;
    }
    public String getString(){
        return stringValue;
    }
}
