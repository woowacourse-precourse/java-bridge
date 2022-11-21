package bridge;

import bridge.type.PositionType;

public class PositionUtils {


    public boolean compareTo(Player player, Bridge bridge, int start) {
        PositionType passPosition = bridge.currentPosition(start);
        PositionType playerPosition = player.currentPosition(start);

        if (passPosition.equals(playerPosition)) {
            return true;
        }

        return false;
    }



}
