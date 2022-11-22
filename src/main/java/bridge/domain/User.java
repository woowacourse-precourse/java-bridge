package bridge.domain;

import static bridge.ExceptionConst.*;

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

    public void reset() {
        movedPosition.clear();
    }

    public UpDownFlag getIndexOf(int index) {
        validateIndex(index);
        return movedPosition.get(index);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= movedPosition.size()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_ILLEGAL_INDEX);
        }
    }
}
