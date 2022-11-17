package bridge.businesslogic;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final List<String> currentlyCrossedBridge;

    public Bridge(BridgeMaker bridgeMaker, int size) {
        this.bridge = bridgeMaker.makeBridge(size);
        this.currentlyCrossedBridge = new ArrayList<>();
    }

    public boolean isSelectedBridgesRight(String usersPick){
        int howManyBridgesCrossed = currentlyCrossedBridge.size();
        String existingBridges = bridge.get(howManyBridgesCrossed);
        return existingBridges.equals(usersPick);
    }

    public void crossBridge(String userPick){
        currentlyCrossedBridge.add(userPick);
    }

    public void dead(){

    }

    public boolean isBridgeAllCrossed(){
        return (currentlyCrossedBridge.size()== bridge.size());
    }

    public List<String> getAlreadyCrossedBridge(){
        return currentlyCrossedBridge;
    }
}
