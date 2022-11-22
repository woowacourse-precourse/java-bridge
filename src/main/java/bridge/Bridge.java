package bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getBridgeSize(){
        return bridge.size();
    }

    public List<String> getBridge(){
        return bridge;
    }

    public boolean correctStep(int bridgeIndex,String move){
        return bridge.get(bridgeIndex).equals(move);
    }
}
