package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> spaces;

    public Bridge(int length) {
        spaces=decideSpaces(length);
    }

    public List<String> decideSpaces(int length){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return bridgeMaker.makeBridge(length);
    }

    public Boolean isSuccess(int nxtLocation,String nxtStep){
        if(nxtStep.equals(this.spaces.get(nxtLocation))){
            return true;
        }
        return false;
    }

}
