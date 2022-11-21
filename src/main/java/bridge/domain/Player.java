package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private Map<Movement, List<String>> movementStatus;
    private int playerPosition;

    public Player() {
        reset();
    }

    public void reset() {
        movementStatus = new HashMap<>() {{
            put(Movement.U, new ArrayList<>());
            put(Movement.D, new ArrayList<>());
        }};
        playerPosition = 0;
    }

    public Map<Movement, List<String>> getMovementStatus() {
        return Collections.unmodifiableMap(movementStatus);
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void crossOverBridge(Movement playerMove, boolean crossable) {
        for(Map.Entry<Movement, List<String>> bridge: movementStatus.entrySet()) {
            String status = " ";
            if(bridge.getKey() == playerMove) {
                status = toStatusAfterCrossOver(crossable);
            }
            bridge.getValue().add(status);
        }
        playerPosition += 1;
    }

    public String toStatusAfterCrossOver(boolean isMoveble){
        if(isMoveble) {
            return "O";
        }
        return "X";
    }


}
