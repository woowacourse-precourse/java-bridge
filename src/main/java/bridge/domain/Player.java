package bridge.domain;

import java.util.List;

public class Player {
    private int currentSpace;

    public Player() {
        currentSpace = 0;
    }

    public boolean move(List<String> bridge, String spaceToMove) {
        int nextSpace = currentSpace + 1;
        if (bridge.get(nextSpace).equals(spaceToMove)) {
            currentSpace += 1;
            return true; // MOVE_SUCCESS
        }
        return false; // MOVE_FAIL
    }
}
