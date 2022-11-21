package bridge.model;

import java.util.List;

public class Bridge {

    private final List<String> bridges;

    public Bridge(List<String> bridges){
        this.bridges = bridges;
    }

    public boolean isPlayerRightBridge(Player player){
        for(int index = 0; index < player.getBridges().size(); index++){
            if(!player.getBridges().get(index).equals(bridges.get(index))) return false;
        }
        return true;
    }

    public List<String> getBridges(){
        return bridges;
    }
}
