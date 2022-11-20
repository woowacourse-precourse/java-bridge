package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> spaces;
    private BridgeMaker bridgeMaker;

    public Bridge(int length,BridgeNumberGenerator bridgeNumberGenerator) {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        spaces=decideSpaces(length);
    }

    public List<String> decideSpaces(int length){
        return bridgeMaker.makeBridge(length);
    }

    public Boolean isSuccess(int nxtLocation,String nxtStep){
        if(nxtStep.equals(this.spaces.get(nxtLocation-1))){
            return true;
        }
        return false;
    }

    public Boolean isFinish(Player player){
        if(player.getCurrentSpace()==spaces.size()-1){
            return true;
        }
        return false;
    }

}
