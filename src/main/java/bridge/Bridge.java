package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final String START_LETTER = "[";
    private static final String FINISH_LETTER = "]";
    private static final String DIVIDE_LETTER = "|";
    private static final String EMPTY_SPACE = " ";
    private static final String SUCCESS_LETTER = "O";
    private static final String FAIL_LETTER = "X";
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public Boolean canMove(String direction, int position) {
        if (direction.equals(BridgeValue.UPPER_BRIDGE.getDirection())) {
            return checkUpper(position);
        }
        if (direction.equals(BridgeValue.LOWER_BRIDGE.getDirection())) {
            return checkLower(position);
        }
        return null;
    }

    private boolean checkUpper(int position) {
        return bridge.get(position).equals(BridgeValue.UPPER_BRIDGE.getDirection());
    }

    private boolean checkLower(int position) {
        return bridge.get(position).equals(BridgeValue.LOWER_BRIDGE.getDirection());
    }

    public List<Bridge> drawInitialBridge() {
        List<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<String> bridge = new ArrayList<>();
            bridge.add(START_LETTER);
            bridges.add(new Bridge(bridge));
        }
        return bridges;
    }

    /**
     * [ O |   ]
     * [   | O ]
     */
    public List<Bridge> drawSuccessLowerBridge(List<Bridge> bridges) {
        bridges.get(0).getBridge().add(EMPTY_SPACE + EMPTY_SPACE + EMPTY_SPACE);
        bridges.get(0).getBridge().add(FINISH_LETTER);
        bridges.get(1).getBridge().add(EMPTY_SPACE + SUCCESS_LETTER + EMPTY_SPACE);
        bridges.get(1).getBridge().add(FINISH_LETTER);
        return bridges;
    }

    /**
     * [ O | O ]
     * [   |   ]
     */
    public List<Bridge> drawSuccessUpperBridge(List<Bridge> bridges) {
        bridges.get(0).getBridge().add(EMPTY_SPACE + SUCCESS_LETTER + EMPTY_SPACE);
        bridges.get(0).getBridge().add(FINISH_LETTER);
        bridges.get(1).getBridge().add(EMPTY_SPACE + EMPTY_SPACE + EMPTY_SPACE);
        bridges.get(1).getBridge().add(FINISH_LETTER);
        return bridges;
    }

    /**
     * [ O |   ]
     * [   | X ]
     */
    public List<Bridge> drawFailLowerBridge(List<Bridge> bridges) {
        bridges.get(0).getBridge().add(EMPTY_SPACE + EMPTY_SPACE + EMPTY_SPACE);
        bridges.get(0).getBridge().add(FINISH_LETTER);
        bridges.get(1).getBridge().add(EMPTY_SPACE + FAIL_LETTER + EMPTY_SPACE);
        bridges.get(1).getBridge().add(FINISH_LETTER);
        return bridges;
    }

    /**
     * [ O | X ]
     * [   |   ]
     */
    public List<Bridge> drawFailUpperBridge(List<Bridge> bridges) {
        bridges.get(0).getBridge().add(EMPTY_SPACE + FAIL_LETTER + EMPTY_SPACE);
        bridges.get(0).getBridge().add(FINISH_LETTER);
        bridges.get(1).getBridge().add(EMPTY_SPACE + EMPTY_SPACE + EMPTY_SPACE);
        bridges.get(1).getBridge().add(FINISH_LETTER);
        return bridges;
    }
}
