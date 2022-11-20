package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridges;

    public Bridge(List<String> bridges){
        this.bridges = bridges;
    }

    public boolean isPlayerRightBridge(Player player){
        return false;
    }

    public List<String> getBridges(){
        return new ArrayList<>();
    }
}
