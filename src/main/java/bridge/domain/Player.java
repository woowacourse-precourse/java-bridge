package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int DISTANCE_DEFAULT_VALUE = 0;
    private int distance = DISTANCE_DEFAULT_VALUE;
    private List<Movement> route = new ArrayList<>();

    public boolean matchPlayerAndBridge(Bridge bridge) {
        List<String> bridgeValues = bridge.getBridge();
        for (int i = 0; i < distance; i++ ) {
            if (!bridgeValues.get(i).equals(route.get(i).getDirection())) {
                return false;
            }
        }
        return true;
    }
    public void updateMovement(Movement movement) {
        distance++;
        route.add(movement);
    }

    public void resetPlayer() {
        distance = DISTANCE_DEFAULT_VALUE;
        route = new ArrayList<>();
    }

    public int getDistance() {
        return distance;
    }

    public List<Movement> getRoute() {
        return List.copyOf(route);
    }
}
