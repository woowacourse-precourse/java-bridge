package bridge.model;

import java.util.List;

public class Bridge {

    private List<String> spaces;
    private BridgeMaker bridgeMaker;

    public Bridge(int length, BridgeNumberGenerator bridgeNumberGenerator) {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        spaces= setSpaces(length);
    }

    public List<String> setSpaces(int length){
        return bridgeMaker.makeBridge(length);
    }

    public Boolean isSuccess(int curLocation,String curStep){
        if(curStep.equals(this.spaces.get(curLocation-1))){
            return true;
        }
        return false;
    }

    public Boolean isFinish(Player player){
        if(player.getCurrentLocation()==spaces.size()){
            return true;
        }
        return false;
    }

    public String checkBridgeSpace(int location) {
        return spaces.get(location-1);
    }

}
