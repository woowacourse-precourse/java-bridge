package bridge;

import bridge.position.Latitude;
import bridge.position.Position;

public class Player {
    private final Position position;

    public Player() {
        position = new Position(-1, null);
    }

    public Position move(Latitude latitude) {
        position.changeLatitude(latitude);
        position.addLongitude();
        return position;
    }
}
