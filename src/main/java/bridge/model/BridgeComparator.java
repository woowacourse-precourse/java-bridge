package bridge.model;

import java.util.List;

public class BridgeComparator {
    private boolean isSuccess = true;

    public boolean isSame(List<String> userBridge, List<String> computerBridge) {
        if (!(userBridge.get(userBridge.size() - 1).equals(computerBridge.get(userBridge.size() - 1)))) {
            isSuccess = false;
        }//if
        return isSuccess;
    }// isCheck
} //end class
