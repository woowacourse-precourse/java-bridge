package bridge.domain;

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
    private final static String END = "]";

    private final List<String> upperBridge;
    private final List<String> lowerBridge;

    public BridgeMap() {
        this.upperBridge = new LinkedList<>();
        this.lowerBridge = new LinkedList<>();
    }

    public void addUpperBridge(boolean isMatch) {
        addSelectBridge(isMatch, upperBridge, lowerBridge);
    }

    public void addLowerBridge(boolean isMatch) {
        addSelectBridge(isMatch, lowerBridge, upperBridge);
    }

    public String getUpperBridgeToString() {
        return getSelectBridgeToString(upperBridge);
    }

    public String getLowerBridgeToString() {
        return getSelectBridgeToString(lowerBridge);
    }

    private boolean isFinish(int bridgeSize) {
        if (upperBridge.size() == bridgeSize) {
            return true;
        }
        return false;
    }

    private String getSelectBridgeToString(List<String> selectBridge) {
        StringBuffer bridge = new StringBuffer(selectBridge.toString().replace(COMMA, SEPARATOR));

        bridge.insert(ONE, " ");
        return bridge.toString();
    }

    private void addSelectBridge(boolean isMatch, List<String> selectBridge, List<String> notSelectBridge) {
        if (isMatch) {
            selectBridge.add(CORRECT);
            notSelectBridge.add(NOT_SELECTED);
            return;
        }
        selectBridge.add(INCORRECT);
        notSelectBridge.add(NOT_SELECTED);
    }
}
