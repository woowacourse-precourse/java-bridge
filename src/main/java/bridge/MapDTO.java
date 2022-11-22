package bridge;

import java.util.List;

public class MapDTO {

    List<String> currentBridge;
    boolean flag;

    public MapDTO(List<String> currentBridge, boolean flag) {
        this.currentBridge = currentBridge;
        this.flag = flag;
    }

    public List<String> getCurrentBridge() {
        return currentBridge;
    }
    public boolean getFlag(){
        return flag;
    }
}
