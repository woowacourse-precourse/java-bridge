package bridge.businesslogic;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int howManyBridgesCrossed;

    public Bridge(BridgeMaker bridgeMaker, int size) {
        this.bridge = bridgeMaker.makeBridge(size);
        this.howManyBridgesCrossed = 0;
    }

    public boolean isSelectedBridgesRight(String usersPick){
        String existingBridges = bridge.get(howManyBridgesCrossed);
        return existingBridges.equals(usersPick);
    }

    public void crossBridge(){
        howManyBridgesCrossed++;
    }

    public void dead(){
        howManyBridgesCrossed = 0;
    }

    public boolean isBridgeAllCrossed(){
        return (howManyBridgesCrossed == bridge.size());
    }
}
