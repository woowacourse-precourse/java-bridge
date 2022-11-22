package bridge.domain;

import java.util.List;

public class Bridge {

    private static int size;
    private static List<String> bridgeLoad;


    public void setBridgeSize(int size) {
        this.size = size;
    }

    public void setBridgeLoad(List<String> bridgeLoad) {
        this.bridgeLoad = bridgeLoad;
    }

    public List<String> getBridgeLoad() {
        return this.bridgeLoad;
    }
}
