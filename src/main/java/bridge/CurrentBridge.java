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

}
