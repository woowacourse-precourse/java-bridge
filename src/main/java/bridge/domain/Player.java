package bridge.domain;

import bridge.util.BridgeLogger;
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

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void crossBridge(BridgeMovement playerMove, boolean isCrossable) {
        for (Map.Entry<BridgeMovement, List<String>> route : movingRoute.entrySet()) {
            boolean isSameBridgeMovement = route.getKey().equals(playerMove);
            CrossState crossState = CrossState.findByStatus(isSameBridgeMovement, isCrossable);
            route.getValue().add(crossState.getStatus());
        }
        playerPosition += 1;
    }

    @Override
    public String toString() {
        return BridgeLogger.log(Collections.unmodifiableMap(movingRoute));
    }
}
