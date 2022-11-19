package bridge.domain;

import bridge.model.BridgeMap;
import bridge.model.Player;

import static bridge.util.BridgeConstant.UP;

public class BridgeMapMaker {
    public final String SUCCESS_BLOCK = "O";
    public final String FAIL_BLOCK = "X";
    
    public void addBridgeMapBlock(Player player, BridgeMap bridgeMap, boolean success) {
        String block = getBlock(success);

        if (player.getYPosition() == UP) {
            bridgeMap.addUpperBridgeMap(block);
            return;
        }
        bridgeMap.addLowerBridgeMap(block);
    }

    private String getBlock(boolean success) {
        if (success) {
            return SUCCESS_BLOCK;
        }
        return FAIL_BLOCK;
    }
}
