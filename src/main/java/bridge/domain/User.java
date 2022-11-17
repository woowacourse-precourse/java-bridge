package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<UpDownFlag> movedPosition;

    public User() {
        movedPosition = new ArrayList<>();
    }

    public void move(UpDownFlag flag) {
        movedPosition.add(flag);
    }

    public int getMovedLength() {
        return movedPosition.size();
    }

    public List<UpDownFlag> getMovedPosition() {
        return List.copyOf(movedPosition);
    }
}
