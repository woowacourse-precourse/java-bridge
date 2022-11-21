package bridge.domain;

import bridge.type.DirectionType;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private List<String> bridgeInfo;

    private Bridge() {
    }

    public void init(List<String> bridgeInfo) {
        this.bridgeInfo = Collections.unmodifiableList(bridgeInfo);
    }

    private static class BridgeHelper {
        private static final Bridge INSTANCE = new Bridge();
    }

    public static Bridge getInstance() {
        return BridgeHelper.INSTANCE;
    }

    public List<String> getBridgeInfo() {
        return bridgeInfo;
    }

}
