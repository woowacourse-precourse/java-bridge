package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public Movable compareSpace(int position, String selectedSpace) {
        String space = bridge.get(position);
        if (space.equals(selectedSpace)) {
            return Movable.O;
        }
        return Movable.X;
    }
}