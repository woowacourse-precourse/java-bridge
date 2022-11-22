package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<String> bridges;
    private int trialCount;

    public Player(){
        bridges = new ArrayList<>();
        trialCount = 1;
    }

    public void addNewBridgeInput(String newBridge){
        bridges.add(newBridge);
    }

    public List<String> getBridges(){
        return bridges;
    }

    public boolean isGameFinished(Bridge bridge){
        return bridges.equals(bridge.getBridges());
    }

    public void clearBridge(){
        bridges = new ArrayList<>();
    }

    public void increaseTrialCount(){
        trialCount++;
    }

    public int getTrialCount(){
        return trialCount;
    }
}
