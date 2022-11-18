package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> moves;

    public Player() {
        moves = new ArrayList<>();
    }

    public void move(String direction) {
        this.moves.add(direction);
    }

    public List<String> getCurrentMap(List<String> bridge, Direction direction) {
        List<String> currentMap = new ArrayList<>();
        for (int index = 0; index < moves.size(); index++) {
            String playerPosition = moves.get(index);
            String bridgePosition = bridge.get(index);
            currentMap.add(comparePosition(playerPosition, bridgePosition, direction));
        }
        return currentMap;
    }

    public String comparePosition(String playerPosition, String bridgePosition, Direction direction) {
        if (playerPosition.equals(direction.getValue())) {
            if (playerPosition.equals(bridgePosition)) {
                return Result.CAN_CROSS.getValue();
            }
            return Result.CANNOT_CROSS.getValue();
        }
        return Result.UNKNOWN.getValue();
    }
}
