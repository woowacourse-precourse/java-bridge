package bridge.model;

import java.util.List;

public class Player {

    public static final int INITIAL_POSITION = -1;
    private int position = INITIAL_POSITION;
    private boolean inWater = false;

    public boolean canMove(List<String> bridge, Direction direction) {
        String nextPosition = bridge.get(position + 1);
        return direction.canMove(nextPosition);
    }

    public void move() {
        position++;
    }

    public boolean isCrossed(List<String> bridge) {
        return position == bridge.size() - 1;
    }

    public void backInitialPosition() {
        position = INITIAL_POSITION;
        inWater = false;
    }

    public void fallIntoWater() {
        inWater = true;
    }

    public boolean isInWater() {
        return inWater;
    }
}