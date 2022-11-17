package bridge;

import static bridge.constant.BridgeMatch.CAN_MOVE;
import static bridge.constant.BridgeMatch.CAN_NOT_MOVE;

import java.util.List;

public class Referee {

    public String compare(List<String> bridge, String player, int count) {
        String block = bridge.get(count);
        if (block.equals(player)) {
            return CAN_MOVE.getSymbol();
        }

        return CAN_NOT_MOVE.getSymbol();
    }
}
