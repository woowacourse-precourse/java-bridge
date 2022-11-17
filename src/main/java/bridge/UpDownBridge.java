package bridge;

import java.util.ArrayList;
import java.util.List;

public class UpDownBridge {
    public static List<String> upBridge = new ArrayList<>();
    public static List<String> downBridge = new ArrayList<>();
    private static final String UP = "U";
    private static final String Down = "D";
    private static final String BLANK = " ";

    public static void makeUpDownBridge(String bridge, String inputDirection) {
        addUpBridge(bridge, inputDirection);
        addDownBridge(bridge, inputDirection);
    }

    public static void addUpBridge(String bridge, String inputDirection) {
        if(bridge.equals(inputDirection)) {
            upBridge.add(inputDirection);
            downBridge.add(BLANK);
        }
    }

    public static void addDownBridge(String bridge, String inputDirection) {
        if(bridge.equals(inputDirection)) {
            upBridge.add(BLANK);
            downBridge.add(inputDirection);
        }
    }
}
