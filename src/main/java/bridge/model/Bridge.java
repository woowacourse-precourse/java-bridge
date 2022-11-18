package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    List<BridgeSpace> bridgeSpaces = new ArrayList<>();

    public Bridge(List<String> bridgeStrs) {
        setBridge(bridgeStrs);
    }

    private void setBridge(List<String> bridgeStrs) {
        bridgeStrs.forEach(str -> {
            bridgeSpaces.add(new BridgeSpace(str));
        });
    }

    public List<BridgeSpace> getBridgeSpaces() {
        return bridgeSpaces;
    }
}
