package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final String MOVE_SUCCESS = " O ";
    private final String MOVE_FAIL = " X ";
    private final String MOVE_EMPTY = "   ";
    private final String MOVE_CONN = "|";
    private final String BRIDGE_START = "[";
    private final String BRIDGE_END = "]";
    private final List<String> bridge;
    private List<String> upStatus;
    private List<String> downStatus;
    private int current;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        upStatus = new ArrayList<>();
        downStatus = new ArrayList<>();
        current = 0;
    }

    private void addSuccessStatus(String moving) {
        if (moving.equals(Position.UP.getValue())) {
            upStatus.add(MOVE_SUCCESS);
            downStatus.add(MOVE_EMPTY);
            return ;
        }
        upStatus.add(MOVE_EMPTY);
        downStatus.add(MOVE_SUCCESS);
    }

    private void addFailStatus(String moving) {
        if (moving.equals(Position.UP.getValue())) {
            upStatus.add(MOVE_FAIL);
            downStatus.add(MOVE_EMPTY);
            return ;
        }
        upStatus.add(MOVE_EMPTY);
        downStatus.add(MOVE_FAIL);
    }

    private boolean isAvailable(String moving) {
        return bridge.get(current).equals(moving);
    }

    public boolean move(String moving) {
        if (!isAvailable(moving)) {
            addFailStatus(moving);
            current++;
            return false;
        }
        addSuccessStatus(moving);
        current++;
        return true;
    }

    public String toString() {
        String result = BRIDGE_START + String.join(MOVE_CONN, upStatus) + BRIDGE_END;
        result += "\n" + BRIDGE_START + String.join(MOVE_CONN, downStatus) + BRIDGE_END;

        return result;
    }


}
