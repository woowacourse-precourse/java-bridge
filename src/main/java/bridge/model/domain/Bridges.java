package bridge.model.domain;

import bridge.constant.Constant;
import java.util.List;

public class Bridges {

    private final List<String> bridges;

    public Bridges(List<String> bridges) {
        this.bridges = bridges;
    }

    String findBridgeByPosition(int position) {
        return bridges.get(position);
    }

    List<String> readBridgeMap(int bridgeLastPosition) {
        return bridges.subList(Constant.INITIAL_INDEX, bridgeLastPosition + Constant.INDEX_ZEROING_NUMBER);
    }

    int size() {
        return bridges.size();
    }
}
