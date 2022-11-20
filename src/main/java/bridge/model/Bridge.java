package bridge.model;

import java.util.Arrays;
import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(int bridgeSize, BridgeMaker bridgeMaker){
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean checkPosition(int position, String moveSquare){
        return bridge.get(position).equals(moveSquare);
    }

    public boolean checkEqual(List<String> playerBridge){
        return Arrays.equals(bridge.toArray(),playerBridge.toArray());
    }
}
