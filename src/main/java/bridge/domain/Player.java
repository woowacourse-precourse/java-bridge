package bridge.domain;

import java.util.List;

public class Player {

    private int distance;
    private List<Movement> route;

    public void updateMovement(Movement movement) {
        distance++;
        route.add(movement);
    }

    public int getDistance() {
        return distance;
    }

    public List<Movement> getRoute() {
        return route;
    }

}
