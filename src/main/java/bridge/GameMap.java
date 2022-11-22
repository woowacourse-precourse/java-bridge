package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private final List<String> upstairBridge = new ArrayList<>();
    private final List<String> downstairBridge = new ArrayList<>();

    public void add(String moveCommand, String moveResult) {
        if (moveCommand.equals("U")) {
            upstairBridge.add(moveResult);
            downstairBridge.add(" ");
        }

        if (moveCommand.equals("D")) {
            downstairBridge.add(moveResult);
            upstairBridge.add(" ");
        }
    }

    public List<String> getUpstairBridge() {
        return upstairBridge;
    }

    public List<String> getDownstairBridge() {
        return downstairBridge;
    }
}
