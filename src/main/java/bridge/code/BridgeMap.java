package bridge.code;

import java.util.HashMap;

public enum BridgeMap{
    FOR_CREATE(new HashMap<Integer,String>(){{
        put(1,"U");
        put(0,"D");
    }}),
    FOR_MOVE(new HashMap<Boolean,String>(){{
        put(true,"O");
        put(false,"X");
    }}),
    FOR_TOTAL(new HashMap<Boolean,String>(){{
        put(true,"성공");
        put(false,"실패");
    }});
    private final HashMap map;

    BridgeMap(HashMap<?,String> map) {
        this.map = map;

    }

}
