package bridge.enums;

public enum IntEnum {
    BRIDGE_START(3),
    BRIDGE_LAST(20);

    private final int num;
    private IntEnum(int num){
        this.num=num;
    }
    public int num(){
        return this.num;
    }
}
