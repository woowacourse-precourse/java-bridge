package bridge.enums;

import java.util.HashMap;
import java.util.Map;

public enum BridgeLine {
    UPPER("U"),
    LOWER("D");

    private final String commandStr;
    private static final Map<String, BridgeLine> strToBridgeLine = new HashMap<>();

    static {
        for (BridgeLine bridgeLine : values()) {
            strToBridgeLine.put(bridgeLine.getCommandStr(), bridgeLine);
        }
    }

    BridgeLine(String commandStr) {
        this.commandStr = commandStr;
    }

    public String getCommandStr() {
        return commandStr;
    }

    public static BridgeLine findBy(String arg) {
        return strToBridgeLine.get(arg);
    }
}
