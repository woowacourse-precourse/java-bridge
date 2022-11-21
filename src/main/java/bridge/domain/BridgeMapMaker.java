package bridge.domain;

import bridge.model.BridgeMap;
import bridge.model.Player;

import static bridge.util.BridgeConstant.FALL_BLOCK;

public class BridgeMapMaker {
    public final String SUCCESS_BLOCK = "O";

    public void addBridgeMapBlock(Player player, boolean success) {
        String block = getBlock(success);
        int playerYPosition = player.getYPosition();
        BridgeMap.getBridgeMap().addBridgeMap(block, playerYPosition);
    }

    private String getBlock(boolean success) {
        if (success) {
            return SUCCESS_BLOCK;
        }
        return FALL_BLOCK;
    }
}
