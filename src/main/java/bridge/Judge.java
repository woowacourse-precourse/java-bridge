package bridge;

import bridge.position.Latitude;
import bridge.position.Position;

import java.util.List;

public class Judge {
    private final List<String> bridge;
    private final Position safePosition;

    public Judge(List<String> bridge) {
        this.bridge = bridge;
        this.safePosition = new Position();
    }

    private Position findNextSafePosition() {
        int safeLongitude = safePosition.addLongitude();
        Latitude safeLatitude = Latitude.valueOfDirection(bridge.get(safeLongitude));
        safePosition.changeLatitude(safeLatitude);
        return safePosition;
    }

    public boolean isPlayerSafe(Position playerPosition) {
        Position safePosition = findNextSafePosition();
        return playerPosition.equals(safePosition);
    }
}
