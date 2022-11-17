package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<UpDownFlag> movedPosition;

    public User() {
        movedPosition = new ArrayList<>();
    }

    public void moveUp() {
        movedPosition.add(UpDownFlag.UP);
    }

    public void moveDown() {
        movedPosition.add(UpDownFlag.DOWN);
    }

    public int getMovedLength() {
        return movedPosition.size();
    }

    public int getCurrentIndex() {
        if (movedPosition.isEmpty()) {
            throw new IllegalStateException("[ERROR] 사용자가 이동한 곳이 없습니다.");
        }
        return movedPosition.size() - 1;
    }

    public List<UpDownFlag> getMovedPosition() {
        return List.copyOf(movedPosition);
    }
}
