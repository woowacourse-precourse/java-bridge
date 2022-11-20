package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private final List<String> upSide;
    private final List<String> downSide;
    private final String SUCCESSFUL_MOVE_FORMAT = " O ";
    private final String FAILED_MOVE_MARK = " X ";
    private final String NEVER_STEPPED_MARK = "   ";

    public BridgeMap() {
        this.upSide = new ArrayList<>();
        this.downSide = new ArrayList<>();
    }

    public List<String> getUpSide() {
        return upSide;
    }

    public List<String> getDownSide() {
        return downSide;
    }

    void update(String direction, boolean gameOver) {
        if (gameOver) {
            markFailedMove(direction);
            return;
        }
        markSuccessfulMove(direction);
    }

    void clear() {
        upSide.clear();
        downSide.clear();
    }

    private void markFailedMove(String direction) {
        if (direction.equals(Moving.UP.getValue())) {
            upSide.add(FAILED_MOVE_MARK);
            downSide.add(NEVER_STEPPED_MARK);
            return;
        }
        upSide.add(NEVER_STEPPED_MARK);
        downSide.add(FAILED_MOVE_MARK);
    }

    private void markSuccessfulMove(String direction) {
        if (direction.equals(Moving.UP.getValue())) {
            upSide.add(SUCCESSFUL_MOVE_FORMAT);
            downSide.add(NEVER_STEPPED_MARK);
            return;
        }
        upSide.add(NEVER_STEPPED_MARK);
        downSide.add(SUCCESSFUL_MOVE_FORMAT);
    }
}
