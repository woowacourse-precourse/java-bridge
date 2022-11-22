package bridge;

import bridge.position.Latitude;
import bridge.position.Position;

public class Player {
    private Position position;
    private boolean life;

    public Player() {
        position = new Position(-1, null);
        life = true;
    }

    public Player(Position position) {
        this.position = position;
        life = true;
    }

    public Position move(Latitude latitude) {
        position.changeLatitude(latitude);
        position.addLongitude();
        return position;
    }

    public void death() {
        life = false;
    }

    public boolean isAlive() {
        return life;
    }

    public boolean isOn(Position position) {
        return this.position.equals(position);
    }

    public void reset() {
        life = true;
        position = new Position(-1, null);
    }
}
