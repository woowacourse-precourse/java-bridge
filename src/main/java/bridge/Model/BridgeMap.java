package bridge.Model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private final List<Bridge> bridge = new ArrayList<>();

    public BridgeMap() {
        bridge.add(new Bridge()); // 윗 다리
        bridge.add(new Bridge()); // 아래 다리
    }
}
