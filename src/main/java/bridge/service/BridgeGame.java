package bridge.service;

import bridge.constant.ErrorCode;
import bridge.constant.MatchConst;
import bridge.domain.Bridge;
import bridge.domain.Player;

import java.util.Objects;

public class BridgeGame {

    public boolean move(String input, Bridge bridge, Player player) {
        boolean isTrue = Objects.equals(input, bridge.getBridgeSpace().get(player.getPlayerLocation()));
        player.addBridgeShapeMatcher(input, isTrue);
        return isTrue;
    }

    public boolean retry(Player player,String gameCommand) {
        if (player.isSuccess()) return false;
        if (Objects.equals(gameCommand, MatchConst.Button.RETRY_BUTTON)) {
            player.removeAllMatcher();
            return true;
        }
        if (Objects.equals(gameCommand, MatchConst.Button.END_BUTTON)) {
            return false;
        }
        throw new IllegalArgumentException(ErrorCode.WRONG_INPUT.getMessage());
    }
}
