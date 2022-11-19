package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridgeList;
    private int bridgeSize;

    private Bridge() {}

    public void init (List<String> bridgeList, int bridgeSize) {
        this.bridgeList = bridgeList;
        this.bridgeSize = bridgeSize;
    }

    private static class BridgeHelper {
        private static final Bridge INSTANCE = new Bridge();
    }

    public static Bridge getInstance() {
        return BridgeHelper.INSTANCE;
    }
}
