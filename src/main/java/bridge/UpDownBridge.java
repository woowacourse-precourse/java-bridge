package bridge;

import java.util.ArrayList;
import java.util.List;

public class UpDownBridge {
    public static StringBuffer upBridge = new StringBuffer();
    public static StringBuffer downBridge = new StringBuffer();
    private static final String UP = "U";
    private static final String Down = "D";
    private static final String BLANK = " ";

    public static void makeUpDownBridge(String bridge, String inputDirection) {
        addUpBridge(bridge, inputDirection);
        addDownBridge(bridge, inputDirection);
    }

    public static void addUpBridge(String bridge, String inputDirection) {
        if(bridge.equals(inputDirection)) {
            upBridge.append(inputDirection);
            downBridge.append(BLANK);
        }
    }

    public static void addDownBridge(String bridge, String inputDirection) {
        if(bridge.equals(inputDirection)) {
            upBridge.append(BLANK);
            downBridge.append(inputDirection);
        }
    }

    public String upBridgeToString() {
        return upBridge.toString();
    }

    public String downBridgeToString() {
        return downBridge.toString();
    }
}
