package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private List<Movement> route;

    public Bridge(List<String> route) {
        this.route = route.stream().map(Movement::valueOf).collect(Collectors.toList());
    }

    public Boolean isCrossable(Movement playerMove, int playerPosition) {
        return route.get(playerPosition) == playerMove;
    }

    public Boolean isReachedTheEnd(int playerPosition) {
        return route.size() == playerPosition;
    }
}
