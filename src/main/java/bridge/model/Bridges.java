package bridge.model;

import java.util.List;

public class Bridges {

    private final List<String> bridge;

    public Bridges(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean judgeMovement(String moveSpace, int index) {
        return bridge.get(index).equals(moveSpace);
    }
}
