package bridge.domain;

import java.util.List;

public enum BridgeHelp {
    UP(1,"U"),
    DOWN(0, "D");

    private final int number;
    private final String value;

    BridgeHelp(int number,String value){
        this.number=number;
        this.value=value;
    }

    public String getValue(){
        return value;
    }

    public static BridgeHelp generateBridge(int number) {
        if(number == UP.number){
            return UP;
        }
        if(number== DOWN.number){
            return DOWN;
        }
        throw new IllegalArgumentException();
    }
}
