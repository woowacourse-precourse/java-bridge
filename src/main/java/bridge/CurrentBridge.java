package bridge;

import java.util.List;

public class CurrentBridge extends Bridge{
    private BridgeStatus bridgeStatus;
    public CurrentBridge(List<String> bridge) {
        super(bridge);
    }
    public BridgeStatus getBridgeStatus(){
        return bridgeStatus;
    }
    public void move(String moveCommand){
        bridge.add(moveCommand);
    }

    public void changeStatus(Bridge otherBridge){
        if(isMove(otherBridge) && this.bridgeLength() == otherBridge.bridgeLength())this.bridgeStatus = BridgeStatus.COMPLETE;
        if(isMove(otherBridge) && this.bridgeLength() != otherBridge.bridgeLength())this.bridgeStatus = BridgeStatus.SUCCESS;
        if(!isMove(otherBridge))this.bridgeStatus = BridgeStatus.FAIL;
    }

    private boolean isMove(Bridge otherBridge){
        int index = this.bridge.size() - 1;
        if(otherBridge.getBridge(index).equals(this.getBridge(index))) return true;
        return false;
    }

}
