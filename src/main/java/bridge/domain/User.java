package bridge.domain;

import java.util.List;
import java.util.Stack;

public class User {
    private final Stack<UpDownFlag> movedPosition;

    public User() {
        movedPosition = new Stack<>();
    }

    public void move(UpDownFlag flag) {
        movedPosition.add(flag);
    }

    public int getMovedLength() {
        return movedPosition.size();
    }

    public int getCurrentIndex() {
        validateEmpty();
        return movedPosition.size() - 1;
    }

    private void validateEmpty() {
        if (movedPosition.isEmpty()) {
            throw new IllegalStateException("[ERROR] 사용자가 이동한 곳이 없습니다.");
        }
    }

    public List<UpDownFlag> getMovedPosition() {
        return List.copyOf(movedPosition);
    }

    public UpDownFlag getCurrentUpDown() {
        validateEmpty();
        return movedPosition.peek();
    }
}
