package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserPosition {
    private List<Position> position;

    private UserPosition() {
        position = new ArrayList<>();
    }
    public static UserPosition newInstance() {
        return new UserPosition();
    }

    public void move(Position position) {
        this.position.add(position);
    }

    public void reset() {
        position.clear();
    }
}
