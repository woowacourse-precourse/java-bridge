package domain;


import bridge.BridgeMaker;

import java.util.List;

public class Bridge {
    BridgeMaker bridgeMaker;

    private static List<String> bridge;

    private Bridge(int bridgeSize){
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public static Bridge getInstance(int bridgeSize) {
        if (bridge == null) {
            bridge = (List<String>) new Bridge(bridgeSize);
        }
        return (Bridge) bridge;
    }
}
