package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<String> bridges;

    public Player(){
        bridges = new ArrayList<>();
    }

    public void addNewBridgeInput(String newBridge){
        bridges.add(newBridge);
    }

    public List<String> getBridges(){
        return bridges;
    }

    public boolean isGameFinished(Bridge bridge){
        return false;
    }
}
