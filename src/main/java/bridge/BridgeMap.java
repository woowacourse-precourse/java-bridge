package bridge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BridgeMap {

    private final static int ONE = 1;
    private final static String CORRECT = "O ";
    private final static String INCORRECT = "X ";
    private final static String NOT_SELECTED = "  ";
    private final static String SEPARATOR = "|";
    private final static String COMMA = ",";
    private final static String START = "[ ";
    private final static String END= "]";

    private final List<String> upperBridge;
    private final List<String> lowerBridge;

    public BridgeMap() {
        this.upperBridge = new LinkedList<>();
        this.lowerBridge = new LinkedList<>();
    }


    public void addUpperBridge(boolean isMatch) {
        if (isMatch) {
            upperBridge.add(CORRECT);
            lowerBridge.add(NOT_SELECTED);
            return;
        }
        upperBridge.add(INCORRECT);
        lowerBridge.add(NOT_SELECTED);
    }

    public void addLowerBridge(boolean isMatch) {
        if (isMatch) {
            lowerBridge.add(CORRECT);
            upperBridge.add(NOT_SELECTED);
            return;
        }
        lowerBridge.add(INCORRECT);
        upperBridge.add(NOT_SELECTED);
    }

    private boolean isFinish(int bridgeSize) {
        if (upperBridge.size() == bridgeSize) {
            return true;
        }
        return false;
    }

    public String getUpperBridgeToString() {
        StringBuffer bridge = new StringBuffer(upperBridge.toString().replace(COMMA, SEPARATOR));

        bridge.insert(ONE, " ");
        return bridge.toString();
    }

    public String getLowerBridgeToString() {
        StringBuffer bridge = new StringBuffer(lowerBridge.toString().replace(COMMA, SEPARATOR));

        bridge.insert(ONE, " ");
        return bridge.toString();
    }
}
