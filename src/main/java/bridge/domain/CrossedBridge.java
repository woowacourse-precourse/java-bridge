package bridge.domain;

import bridge.domain.bridgeenum.MoveStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrossedBridge {
    private List<String> crossedBridge;

    public CrossedBridge() {
        crossedBridge = new ArrayList<>();
    }

    public void updateMoveResult(Boolean success) {
        crossedBridge.add(MoveStatus.findMarkByValue(success));
    }

    public List<String> getCrossedBridge() {
        return Collections.unmodifiableList(crossedBridge);
    }

}
