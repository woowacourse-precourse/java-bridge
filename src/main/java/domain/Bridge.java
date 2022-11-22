package domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(String direction, int position) {
        return bridge.get(position).equals(direction);
    }

    public boolean completeCross(List<String> progress) {
        return bridge.equals(progress);
    }
}
