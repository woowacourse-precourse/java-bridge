package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserPosition {
    private List<Position> userPosition;

    private UserPosition() {
        userPosition = new ArrayList<>();
    }
    public static UserPosition newInstance() {
        return new UserPosition();
    }

    public void move(Position position) {
        this.userPosition.add(position);
    }

    public void reset() {
        userPosition.clear();
    }

    public int size() {
        return userPosition.size();
    }

    public boolean upAt(int i) {
        return userPosition.get(i).isUp();
    }

    public boolean downAt(int i) {
        return userPosition.get(i).isDown();
    }
}
