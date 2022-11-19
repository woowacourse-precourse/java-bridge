package enums;

public enum BridgeEnum {
    D(0),
    U(1);

    private final int spot;

    BridgeEnum(int spot){
        this.spot = spot;
    }

    public int getValue(){
        return spot;
    }
}
