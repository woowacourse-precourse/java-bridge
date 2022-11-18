package bridge;

import java.util.ArrayList;
import java.util.List;

public class UpDownBridge {
    public static StringBuffer upBridge = new StringBuffer();
    public static StringBuffer downBridge = new StringBuffer();
    private static final String UP = "U";
    private static final String Down = "D";
    private static final String BLANK = " ";

    public static void makeUpDownBridge(String inputDirection, String moveResult) {
        addUpBridge(inputDirection, moveResult);
        addDownBridge(inputDirection, moveResult);
    }

    public static void addUpBridge(String inputDirection, String moveResult) {
        if(inputDirection.equals(UP)) {
            upBridge.append(moveResult);
            downBridge.append(BLANK);
        }
    }

    public static void addDownBridge(String inputDirection, String moveResult) {
        if(inputDirection.equals(Down)) {
            upBridge.append(BLANK);
            downBridge.append(moveResult);
        }
    }
}
