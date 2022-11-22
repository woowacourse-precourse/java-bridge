package bridge.enums;

import java.util.HashMap;
import java.util.Map;

public enum BridgeMakerMapping {
    DOWN(0, "D"),
    UP(1, "U");

    private final int num;
    private final String str;
    private static final Map<Integer, BridgeMakerMapping> numToStringMapping = new HashMap<>();

    static {
        for (var e : values()) {
            numToStringMapping.put(e.getNum(), e);
        }
    }

    BridgeMakerMapping(int num, String str) {
        this.num = num;
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public String getStr() {
        return str;
    }

    public static BridgeMakerMapping findBy(int num) {
        return numToStringMapping.get(num);
    }
}
