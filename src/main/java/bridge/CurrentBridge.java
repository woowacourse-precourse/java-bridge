package bridge;

import java.util.List;

public class CurrentBridge extends Bridge{
    private BridgeStatus bridgeStatus;
    public CurrentBridge(List<String> bridge) {
        super(bridge);
        bridgeStatus = BridgeStatus.SUCCESS;
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
        if(!isMove(otherBridge)) this.bridgeStatus = BridgeStatus.FAIL;
    }

    private boolean isMove(Bridge otherBridge){
        int index = this.bridge.size() - 1;
        if(otherBridge.getBridge(index).equals(this.getBridge(index))) return true;
        return false;
    }
    public void reset(){
        bridgeStatus = BridgeStatus.SUCCESS;
        bridge.clear();
    }
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0;i<bridge.size();i++) buffer.append(returnString(BridgeConst.UP,i));
        for(int i = 0;i<bridge.size();i++) buffer.append(returnString(BridgeConst.DOWN,i));
        return buffer.toString();
    }
    private String returnString(String del,int index){
        if(bridge.get(index).equals(del) && bridgeStatus == BridgeStatus.FAIL && index == bridgeLength() - 1) return "X";
        if(bridge.get(index).equals(del))return "O";
        return " ";
    }



}
/**
 * [ O | X ]
 * [   |   ]
 */