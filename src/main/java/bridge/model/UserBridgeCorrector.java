package bridge.model;

import java.util.List;

public class UserBridgeCorrector {
    public List<String> addBridge(String movement,List<String> userSelectResult) {
        userSelectResult.add(movement);
        return userSelectResult;
    }// correctBridge
} // end class
