package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class CurrentBridgeMap {
    private static final String BLANK_BRIDGE = "   ";
    private static final String ANSWER_BRIDGE = " O ";
    private static final String WRONG_BRIDGE = " X ";
    private static final String BRIDGE_STRUCTURE = "[%s]\n[%s]";
    private static final String SEPARATE_BRIDGE = "|";
    private static final String UPPER_CHECK = "U";
    private static final String LOWER_CHECK = "D";

    private final List<String> upperBridgeMap;
    private final List<String> lowerBridgeMap;

    public CurrentBridgeMap() {
        upperBridgeMap = new ArrayList<>();
        lowerBridgeMap = new ArrayList<>();
    }

    public String getCurrentBridgeMap(String playerChoice, Boolean equalAnswer) {
        updateUpperBridgeMap(playerChoice, equalAnswer);
        updateLowerBridgeMap(playerChoice, equalAnswer);
        return getBridgeMap();
    }

    private void updateUpperBridgeMap(String playerChoice, Boolean equalAnswer) {
        if (playerChoice.equals(UPPER_CHECK) && equalAnswer) {
            upperBridgeMap.add(ANSWER_BRIDGE);
            return;
        }
        if (playerChoice.equals(UPPER_CHECK)) {
            upperBridgeMap.add(WRONG_BRIDGE);
            return;
        }

        upperBridgeMap.add(BLANK_BRIDGE);
    }

    private void updateLowerBridgeMap(String playerChoice, Boolean equalAnswer) {
        if (playerChoice.equals(LOWER_CHECK) && equalAnswer) {
            lowerBridgeMap.add(ANSWER_BRIDGE);
            return;
        }
        if (playerChoice.equals(LOWER_CHECK)) {
            lowerBridgeMap.add(WRONG_BRIDGE);
            return;
        }

        lowerBridgeMap.add(BLANK_BRIDGE);
    }

    public String getBridgeMap() {
        return String.format(BRIDGE_STRUCTURE, String.join(SEPARATE_BRIDGE, upperBridgeMap), String.join(SEPARATE_BRIDGE, lowerBridgeMap));
    }
}
