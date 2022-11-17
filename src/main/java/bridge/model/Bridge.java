package bridge.model;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(Player player) {
        return player.getDirections().size() < bridge.size();
    }

    public void validateDirection(int index, String direction) {
        if (outOfIndex(index) || notMatch(index, direction)) {
            throw new IllegalStateException();
        }
    }

    private boolean outOfIndex(int index) {
        return index >= bridge.size();
    }

    private boolean notMatch(int index, String direction) {
        return !bridge.get(index).equals(direction);
    }

}
