package bridge.domain;

import java.util.Collections;
import java.util.List;

public class BridgeJudge {

    private List<String> bridge;

    public void addBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public boolean isFailToMove(List<String> moveHistory) {
        for (int i=0; i<moveHistory.size(); i++) {
            String direction = moveHistory.get(i);
            String answer = bridge.get(i);
            if (!direction.equals(answer)) {
                return true;
            }
        }
        return false;
    }
    public boolean isCompleteToMove(List<String> moveHistory) {
        if (moveHistory.size() != bridge.size()) {
            return false;
        }
        if (isFailToMove(moveHistory)) {
            return false;
        }
        return true;
    }
}
