package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeResult {
    private final String BLANK = " ";

    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

    public void putResult(BridgeDirection direction, Answer answer) {
        if (direction == BridgeDirection.UP) {
            upBridge.add(answer.getMessage());
            downBridge.add(BLANK);
        }
        if (direction == BridgeDirection.DOWN) {
            upBridge.add(BLANK);
            downBridge.add(answer.getMessage());
        }
    }

    public void reset() {
        upBridge.clear();
        downBridge.clear();
    }

    public List<String> getUpBridge() {
        return Collections.unmodifiableList(upBridge);
    }

    public List<String> getDownBridge() {
        return Collections.unmodifiableList(downBridge);
    }
}
