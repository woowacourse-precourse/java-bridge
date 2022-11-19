package bridge.service;

import bridge.model.BridgeDTO;

import java.util.List;

public class UserBridgeCorrector {
    public List<String> addBridge(String movement) {
        List<String> bridge = BridgeDTO.getUserResult();
        bridge.add(movement);
        return BridgeDTO.getUserResult();
    }// correctBridge
} // end class
