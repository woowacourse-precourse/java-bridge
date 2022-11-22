package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private static final String UP_COMMAND = "U";
    private static final String DOWN_COMMAND = "D";
    private static final String BLANK_MARK = " ";
    private final List<String> upstairBridge = new ArrayList<>();
    private final List<String> downstairBridge = new ArrayList<>();

    public void add(String moveCommand, String moveResult) {
        if (moveCommand.equals(UP_COMMAND)) {
            upstairBridge.add(moveResult);
            downstairBridge.add(BLANK_MARK);
        }

        if (moveCommand.equals(DOWN_COMMAND)) {
            downstairBridge.add(moveResult);
            upstairBridge.add(BLANK_MARK);
        }
    }

    public List<String> getUpstairBridge() {
        return upstairBridge;
    }

    public List<String> getDownstairBridge() {
        return downstairBridge;
    }

    public void clear() {
        upstairBridge.clear();
        downstairBridge.clear();
    }
}
