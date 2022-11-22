package bridge;

import bridge.position.Latitude;
import bridge.position.Position;

import java.util.List;

public class Judge {
    private final List<String> bridge;
    private final Position safePosition;
    private final Position goal;

    public Judge(List<String> bridge) {
        this.bridge = bridge;
        this.safePosition = new Position();
        this.goal = findGoalPosition();
    }

    private Position findNextSafePosition() {
        int safeLongitude = safePosition.addLongitude();
        Latitude safeLatitude = Latitude.valueOfDirection(bridge.get(safeLongitude));
        safePosition.changeLatitude(safeLatitude);
        return safePosition;
    }

    public Position findGoalPosition() {
        int longitude = bridge.size() - 1;
        Latitude latitude = Latitude.valueOfDirection(bridge.get(longitude));
        return new Position(longitude, latitude);
    }

    public boolean isPlayerSafe(Position playerPosition) {
        Position safePosition = findNextSafePosition();
        return playerPosition.equals(safePosition);
    }

    public boolean isPlayerWin(Player player) {
        return player.isOn(goal);
    }

    public void reset() {
        safePosition.init();
    }
}
