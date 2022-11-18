package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridges {
    List<Bridge> bridges;

    public Bridges(Bridge firstBridge, Bridge secondBridge) {
        bridges = new ArrayList<>();
        bridges.add(firstBridge);
        bridges.add(secondBridge);
    }
}
