package bridge.repository;

import java.util.List;

public class BridgeRepository {
    private List<String> upBridges;
    private List<String> downBridges;


    public void save(final List<String> result) {
        String upBridgeInfo = result.get(0);
        String downBridgeInfo = result.get(1);

        upBridges.add(upBridgeInfo);
        downBridges.add(downBridgeInfo);
    }
}
