package bridge.dto;

import java.util.List;

public class BridgeDto {
    private final List<String> bridge;
    private int currentStage = 0;

    public BridgeDto(List<String> bridge) {
        this.bridge = bridge;
    }

    public void restart() {
        currentStage = 0;
    }

    public int getCurrentStage() {
        return currentStage;
    }

    public String getCurrentBridge() {
        return bridge.get(currentStage);
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void increaseCurrentStage() {
        currentStage++;
    }
}
