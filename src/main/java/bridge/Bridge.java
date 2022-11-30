package bridge;

import java.util.List;

public class Bridge {
    private List<String> answerBridge;

    public Bridge(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

    public boolean isRightDirection(int index, String direction) {
        if (answerBridge.get(index).equals(direction)) {
            return true;
        }
        return false;
    }

    public boolean isCrossedBridge(List<String> visited) {
        if (visited.size() == answerBridge.size()) {
            return true;
        }
        return false;
    }
}
