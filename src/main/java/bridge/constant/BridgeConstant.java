package bridge.constant;

public enum BridgeConstant {
    CAN_GO_UP(1,"U") , CANT_GO_UP(0,"D");
    int intValue;
    String stringValue;
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
