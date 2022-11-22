package bridge.model;

import java.util.Arrays;
import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge = bridge;
    }

    public boolean checkEqual(List<String> playerBridge){
        return Arrays.equals(bridge.subList(0, playerBridge.size()).toArray(),playerBridge.toArray());
    }

    public boolean isSame(List<String> playerBridge){
        return Arrays.equals(bridge.toArray(), playerBridge.toArray());
    }

    public String toString(){
        return bridge.toString();
    }
}
