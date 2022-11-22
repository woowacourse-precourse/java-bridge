package bridge.businesslogic;

import bridge.businesslogic.bridgestatus.BridgeCrossingStatus;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final List<String> currentlyCrossedBridge;
    private final BridgeCrossingStatus status;

    public Bridge(BridgeMaker bridgeMaker, int size) {
        this.bridge = bridgeMaker.makeBridge(size);
        this.currentlyCrossedBridge = new ArrayList<>();
        StringBuilder upLine = new StringBuilder();
        StringBuilder downLine = new StringBuilder();
        this.status = new BridgeCrossingStatus(upLine,downLine);
    }

    public boolean isSelectedBridgesRight(String usersPick){
        int howManyBridgesCrossed = currentlyCrossedBridge.size();
        String existingBridges = bridge.get(howManyBridgesCrossed);
        return existingBridges.equals(usersPick);
    }

    public void crossBridge(String userPick){
        currentlyCrossedBridge.add(userPick);
        status.updateStatus(userPick);
    }

    public void reset(){
        currentlyCrossedBridge.clear();
        status.clearAll();
    }

    public boolean isBridgeAllCrossed(){
        return (currentlyCrossedBridge.size()== bridge.size());
    }

    public List<String> getAlreadyCrossedBridge(boolean isLastPickIsRight){
        return List.of(
                status.getBridgeStatus("U",isLastPickIsRight),
                status.getBridgeStatus("D",isLastPickIsRight)
        );
    }
}
