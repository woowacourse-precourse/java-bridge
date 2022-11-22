package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<BridgeMovement> route;

    public Bridge(List<String> route) {
        this.route = route.stream().map(BridgeMovement::findByMovement).collect(Collectors.toList());
    }

    public Boolean isCrossable(BridgeMovement playerMove, int playerPosition) {
        return route.get(playerPosition) == playerMove;
    }

    public Boolean isReachedTheEnd(int playerPosition) {
        return route.size() == playerPosition;
    }
}
