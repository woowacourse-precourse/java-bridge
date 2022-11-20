package bridge.dto.output;

import bridge.domain.game.Bridge;
import bridge.domain.game.BridgeTile;
import bridge.domain.player.Player;

public class PrintMapDto {

    private final String upBridgeHistory;
    private final String downBridgeHistory;

    public PrintMapDto(final Bridge bridge, final Player player) {
        this.upBridgeHistory = player.getPlayerTargetTileHistory(bridge, BridgeTile.UP);
        this.downBridgeHistory = player.getPlayerTargetTileHistory(bridge, BridgeTile.DOWN);
    }

    public String getUpBridgeHistory() {
        return upBridgeHistory;
    }

    public String getDownBridgeHistory() {
        return downBridgeHistory;
    }
}
