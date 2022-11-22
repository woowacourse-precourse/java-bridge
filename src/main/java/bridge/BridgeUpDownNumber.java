package bridge;

import static bridge.common.BridgeGameConstants.DOWN;
import static bridge.common.BridgeGameConstants.UP;

public class BridgeUpDownNumber {

    public int upOrDown(String upDown){
        int upDownNumber=-1;
        if(upDown==DOWN) {
            upDownNumber = 1;
        }
        if(upDown==UP){
            upDownNumber = 0;
        }
        return upDownNumber;
    }

}
