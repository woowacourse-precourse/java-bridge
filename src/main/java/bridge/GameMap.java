package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private static final String UP_COMMAND = "U";
    private static final String DOWN_COMMAND = "D";
    private static final String BLANK_MARK = " ";
    private final List<String> upperBridge = new ArrayList<>();
    private final List<String> lowerBridge = new ArrayList<>();

    public void add(String moveCommand, String moveResult) {
        if (moveCommand.equals(UP_COMMAND)) {
            upperBridge.add(moveResult);
            lowerBridge.add(BLANK_MARK);
        }

        if (moveCommand.equals(DOWN_COMMAND)) {
            lowerBridge.add(moveResult);
            upperBridge.add(BLANK_MARK);
        }
    }

    public List<String> getUpperBridge() {
        return upperBridge;
    }

    public List<String> getLowerBridge() {
        return lowerBridge;
    }

    public void clear() {
        upperBridge.clear();
        lowerBridge.clear();
    }
}
