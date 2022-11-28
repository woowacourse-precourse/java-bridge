package bridge.domain;

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
        if(!isMove(otherBridge)) this.bridgeStatus = BridgeStatus.FAIL;
        if(isMove(otherBridge) && isFinal(otherBridge))this.bridgeStatus = BridgeStatus.COMPLETE;
        if(isMove(otherBridge) && !isFinal(otherBridge))this.bridgeStatus = BridgeStatus.SUCCESS;
    }

    private boolean isFinal(Bridge otherBridge){
        if(this.bridgeLength() == otherBridge.bridgeLength()) return true;
        return false;
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

    private String returnString(String upNDown,int index){
        if(isSame(upNDown,index) && isFail() && isFinal(index)) return "X";
        if(isSame(upNDown,index)) return "O";
        return " ";
    }

    private boolean isSame(String upNDown,int index){
        if(this.bridge.get(index).equals(upNDown)) return true;
        return false;
    }

    private boolean isFail(){
        if(this.bridgeStatus == BridgeStatus.FAIL) return true;
        return false;
    }

    private boolean isFinal(int index){
        if(bridgeLength() == index + 1) return true;
        return false;
    }

}
/**
 * [ O | X ]
 * [   |   ]
 */