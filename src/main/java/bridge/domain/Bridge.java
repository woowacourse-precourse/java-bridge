package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bridge {
    private List<Movement> route;

    public Bridge(List<String> route) {
        this.route = route.stream().map(Movement::valueOf).collect(Collectors.toList());
    }

    public Boolean isMoveable(Movement userMove, int userPosition) {
        return route.get(userPosition) == userMove;
    }
}
