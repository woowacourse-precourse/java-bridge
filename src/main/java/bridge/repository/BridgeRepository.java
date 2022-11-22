package bridge.repository;

import java.util.ArrayList;
import java.util.List;

public class BridgeRepository {

    private final List<String> upBridges = new ArrayList<>();
    private final List<String> downBridges = new ArrayList<>();

    public void save(final List<String> result) {
        String upBridgeInfo = result.get(0);
        String downBridgeInfo = result.get(1);

        upBridges.add(upBridgeInfo);
        downBridges.add(downBridgeInfo);
    }

    public List<String> getUpBridges() {
        return this.upBridges;
    }

    public List<String> getDownBridges() {
        return this.downBridges;
    }

    public void clear() {
        this.upBridges.clear();
        this.downBridges.clear();
    }
}
