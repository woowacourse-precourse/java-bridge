package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Direction> route = new ArrayList<>();
    private boolean inWater = false;

    public void move(List<String> bridge, Direction direction) {
        route.add(direction);
        if (direction.correct(bridge.get(route.size() - 1))) {
            inWater = true;
        }
    }

    public boolean isCrossed(List<String> bridge) {
        return route.size() == bridge.size() && !inWater;
    }

    public void backInitialPosition() {
        route = new ArrayList<>();
        inWater = false;
    }

    public boolean isInWater() {
        return inWater;
    }
}