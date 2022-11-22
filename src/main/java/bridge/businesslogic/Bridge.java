package bridge.businesslogic;

import bridge.businesslogic.bridgehistorystatus.BridgeCrossingHistory;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final List<String> currentlyCrossedBridge;
    private final BridgeCrossingHistory history;

    public Bridge(BridgeMaker bridgeMaker, int size) {
        this.bridge = bridgeMaker.makeBridge(size);
        this.currentlyCrossedBridge = new ArrayList<>();
        StringBuilder upLine = new StringBuilder();
        StringBuilder downLine = new StringBuilder();
        this.history = new BridgeCrossingHistory(upLine,downLine);
    }

    public boolean isSelectedBridgesRight(String usersPick){
        int howManyBridgesCrossed = currentlyCrossedBridge.size();
        String existingBridges = bridge.get(howManyBridgesCrossed);
        return existingBridges.equals(usersPick);
    }

    public void crossBridge(String userPick){
        currentlyCrossedBridge.add(userPick);
        history.updateHistory(userPick);
    }

    public void reset(){
        currentlyCrossedBridge.clear();
        history.clearAll();
    }

    public boolean isBridgeAllCrossed(){
        return (currentlyCrossedBridge.size()== bridge.size());
    }

    public List<String> getAlreadyCrossedBridge(boolean isLastPickIsRight){
        return List.of(
                history.getBridgeHistory("U",isLastPickIsRight),
                history.getBridgeHistory("D",isLastPickIsRight)
        );
    }
}
