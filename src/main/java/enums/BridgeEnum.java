package enums;

public enum BridgeEnum {
    MIN_SIZE(3),
    MAX_SIZE(20),
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
