package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int distance = 0;
    private List<Movement> route = new ArrayList<>();

    public void updateMovement(Movement movement) {
        distance += 1;
        route.add(movement);
    }

    public int getDistance() {
        return distance;
    }

    public List<Movement> getRoute() {
        return route;
    }

}
