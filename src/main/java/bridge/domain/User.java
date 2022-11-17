package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<UpDownFlag> movedPosition;

    public User() {
        this.movedPosition = new ArrayList<>();
    }

    public void moveUp() {
        this.movedPosition.add(UpDownFlag.UP);
    }

    public void moveDown() {
        this.movedPosition.add(UpDownFlag.DOWN);
    }

    public int getCurrentIndex() {
        return this.movedPosition.size();
    }

    public List<UpDownFlag> getMovedPosition() {
        return List.copyOf(this.movedPosition);
    }
}
