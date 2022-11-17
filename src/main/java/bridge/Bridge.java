package bridge;

import java.util.HashMap;

public class Bridge {
    private static final HashMap<Integer,String> bridge = new HashMap<>(){{
        put(1,"U");
        put(0,"D");
    }};

    public static String getSymbol(int code){
        return bridge.get(code);
    }
}
