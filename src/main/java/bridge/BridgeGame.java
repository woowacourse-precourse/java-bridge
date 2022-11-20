package bridge;

import bridge.constant.Constant;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private List<List<String>> bridgeMap = new ArrayList<>();

    public void initMap() {
        bridgeMap.clear();
        for (int i = 0; i < Constant.BRIDGE_WIDTH; i++) {
            bridgeMap.add(new ArrayList<>());
        }
    }

    public void move() {
    }

    public void retry() {
    }
}
