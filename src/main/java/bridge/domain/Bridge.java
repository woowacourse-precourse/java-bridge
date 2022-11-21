package bridge.domain;

import java.util.List;

public class Bridge {
    private static List<String> bridge;
    private int bridgeSize;


    public Bridge(List<String> lst) {
        bridge = lst;
        bridgeSize = lst.size();
    }

    public String getBridgeAnswer(final int index) {
        return bridge.get(index);
    }

    public int getBridgeSize() {return bridgeSize;}
}