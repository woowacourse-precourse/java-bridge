package bridge;

import java.util.List;

public class Bridge {
    private List<String> targetBridge;

    public Bridge() {
        this.targetBridge = null;
    }

    public List<String> getTargetBridge() {
        return targetBridge;
    }
    public void setTargetBridge(List<String> bridge) {
        targetBridge = bridge;
    }
    public boolean getComparison(int index,String command) {
        if(getTargetBridge().get(index).equals(command)) {
            return true;
        }
        return false;
    }
}
