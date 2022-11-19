package bridge.domain;

import bridge.model.BridgeMap;
import bridge.model.Player;

import static bridge.util.BridgeConstant.UP_POSITION;

public class BridgeMapMaker {
    public final String SUCCESS_BLOCK = "O";
    public final String FAIL_BLOCK = "X";

    public void addBridgeMapBlock(Player player, boolean success) {
        BridgeMap bridgeMap = BridgeMap.getBridgeMap();
        String block = getBlock(success);

        if (player.getYPosition() == UP_POSITION) {
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
