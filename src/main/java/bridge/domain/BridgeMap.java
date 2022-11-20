package bridge.domain;

import bridge.constant.BridgeMapConstants;
import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private final List<String> upSide;
    private final List<String> downSide;

    public BridgeMap() {
        this.upSide = new ArrayList<>();
        this.downSide = new ArrayList<>();
    }

    public String getPrintFormat() {
        return "[" + String.join("|", upSide) + "]\n"
                + "[" + String.join("|", downSide) + "]\n";
    }

    public void update(String direction, boolean gameOver) {
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
            upSide.add(BridgeMapConstants.FAILED_MOVE_MARK);
            downSide.add(BridgeMapConstants.NEVER_STEPPED_MARK);
            return;
        }
        upSide.add(BridgeMapConstants.NEVER_STEPPED_MARK);
        downSide.add(BridgeMapConstants.FAILED_MOVE_MARK);
    }

    private void markSuccessfulMove(String direction) {
        if (direction.equals(Moving.UP.getValue())) {
            upSide.add(BridgeMapConstants.SUCCESSFUL_MOVE_FORMAT);
            downSide.add(BridgeMapConstants.NEVER_STEPPED_MARK);
            return;
        }
        upSide.add(BridgeMapConstants.NEVER_STEPPED_MARK);
        downSide.add(BridgeMapConstants.SUCCESSFUL_MOVE_FORMAT);
    }
}
