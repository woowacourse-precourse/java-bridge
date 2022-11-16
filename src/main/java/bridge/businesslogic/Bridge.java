package bridge.businesslogic;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

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

    public List<String> getAlreadyCrossedBridge(){
        List<String> alreadyCrossedBridge = newArrayList();
        for(int i = 0; i < howManyBridgesCrossed; i++){
            alreadyCrossedBridge.add(bridge.get(i));
        }
        return alreadyCrossedBridge;
    }
}
