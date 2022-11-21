package bridge.model;

import java.util.Collections;
import java.util.List;

public class Bridge {

    private List<String> bridge;
    private int currentRoundNumber = 0;

    public Bridge (List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge () {
        return Collections.unmodifiableList(bridge);
    }

    public Boolean isRoundLeft(int currentRoundNumber) {
        int finalRound = bridge.size();
        return currentRoundNumber < finalRound;
    }

    public void addCurrentRoundNumber() {
        currentRoundNumber +=1 ;
    }

    public void resetCurrentRoundNumber() {
        currentRoundNumber = 0;
    }

    public int getCurrentRoundNumber() {
        return currentRoundNumber;
    }
}