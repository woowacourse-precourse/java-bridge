package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<String> movedPosition;

    public User() {
        this.movedPosition = new ArrayList<>();
    }

    public void moveUp() {
        this.movedPosition.add("U");
    }

    public void moveDown() {
        this.movedPosition.add("D");
    }

    public int getCurrentIndex() {
        return this.movedPosition.size();
    }

    public List<String> getMovedPosition() {
        return List.copyOf(this.movedPosition);
    }
}
