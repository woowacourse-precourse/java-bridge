package bridge;

import java.util.ArrayList;
import java.util.List;

public class UpDownBridge {
    public static List<String> upBridge = new ArrayList<>();
    public static List<String> downBridge = new ArrayList<>();
    private static final String UP = "U";
    private static final String Down = "D";
    private static final String BLANK = " ";

    public static void makeUpDownBridge(String inputDirection, String bridgeResult) {
        addUpBridge(inputDirection, bridgeResult);
        addDownBridge(inputDirection, bridgeResult);
    }

    public static void addUpBridge(String inputDirection, String bridgeResult) {
        if(inputDirection.equals(UP)) {
            upBridge.add(bridgeResult);
            downBridge.add(BLANK);
        }
    }

    public static void addDownBridge(String inputDirection, String bridgeResult) {
        if(inputDirection.equals(Down)) {
            upBridge.add(BLANK);
            downBridge.add(bridgeResult);
        }
    }
}
