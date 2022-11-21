package bridge.model;

import java.util.List;

public class BridgeComparator {
    
    public boolean isSame(List<String> userBridge, List<String> computerBridge) {
        boolean isSuccess = true;
        if (!(userBridge.get(userBridge.size() - 1).equals(computerBridge.get(userBridge.size() - 1)))) {
            isSuccess = false;
        }//if
        return isSuccess;
    }// isCheck
} //end class
