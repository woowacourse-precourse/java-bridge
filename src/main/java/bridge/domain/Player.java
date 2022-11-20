package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Long numberOfTry;
    private List<String> upperBridge;
    private List<String> lowerBridge;

    public Player() {
        numberOfTry = 0L;
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
    }

    public Long getNumberOfTry() {
        return numberOfTry;
    }

    public List<String> getUpperBridge() {
        return upperBridge;
    }

    public List<String> getLowerBridge() {
        return lowerBridge;
    }

}