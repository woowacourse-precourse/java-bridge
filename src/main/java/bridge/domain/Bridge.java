package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridgeStatus;

    public Bridge(List<String> bridgeStatus) {
        this.bridgeStatus = bridgeStatus;
    }

    public int getBridgeLength(){
        return bridgeStatus.size();
    }

    public boolean canCross(Integer lastPosition, String moving) {
        if(bridgeStatus.get(lastPosition).equals(moving)){
            return true;
        }
    }
}
