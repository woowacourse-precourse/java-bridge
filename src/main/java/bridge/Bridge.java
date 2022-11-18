package bridge;

import java.util.List;

public class Bridge {
    private final int bridgeSize;
    private List<String> bridge;

    public Bridge(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        requestNewBridge();
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    private void requestNewBridge(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean isEqualToChoice(int idx, String choice){
        return choice.equals(bridge.get(idx));
    }
}
