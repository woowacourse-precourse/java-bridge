package domain;


import bridge.BridgeMaker;

public class Bridge {
    BridgeMaker bridgeMaker;

    private static Bridge bridge = null;

    private Bridge(int bridgeSize){
        this.bridge = (Bridge) bridgeMaker.makeBridge(bridgeSize);
    }

    public static Bridge getInstance(int bridgeSize) {
        if (bridge == null) {
            bridge = new Bridge(bridgeSize);
        }
        return bridge;
    }
}
