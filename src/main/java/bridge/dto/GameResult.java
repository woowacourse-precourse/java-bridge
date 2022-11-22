package bridge.dto;

import java.util.List;

public class GameResult {
    private Boolean result;
    private Long numberOfTry;
    private List<String> upperBridge;
    private List<String> lowerBridge;

    public GameResult(Boolean result, Long numberOfTry, List<String> upperBridge, List<String> lowerBridge) {
        this.result = result;
        this.numberOfTry = numberOfTry;
        this.upperBridge = upperBridge;
        this.lowerBridge = lowerBridge;
    }

    public Boolean getResult() {
        return result;
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