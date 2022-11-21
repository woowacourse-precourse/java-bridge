package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private Map<BridgeMovement, List<String>> movingRoute;
    private int playerPosition;

    public Player() {
        reset();
    }

    public void reset() {
        movingRoute = new HashMap<>() {{
            put(BridgeMovement.UP, new ArrayList<>());
            put(BridgeMovement.DOWN, new ArrayList<>());
        }};
        playerPosition = 0;
    }

    public Map<BridgeMovement, List<String>> getMovingRoute() {
        return Collections.unmodifiableMap(movingRoute);
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void crossOverBridge(BridgeMovement playerMove, boolean crossable) {
        for(Map.Entry<BridgeMovement, List<String>> route: movingRoute.entrySet()) {
            String status = " ";
            if(route.getKey() == playerMove) {
                status = toStatusAfterCrossOver(crossable);
            }
            route.getValue().add(status);
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
