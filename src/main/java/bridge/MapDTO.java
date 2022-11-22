package bridge;

import java.util.List;

public class MapDTO {

    List<String> currentBridge;
    boolean flag;

    public MapDTO() {
    }

    public void setCurrentBridge(List<String> currentBridge) {
        this.currentBridge = currentBridge;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<String> getCurrentBridge() {
        return currentBridge;
    }
    public boolean getFlag(){
        return flag;
    }
}
