package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.CurrentBridge;

import java.util.HashMap;
import java.util.Map;

public class BridgeGame {

    private final Bridge bridge;
    private CurrentBridge currentBridge;
    private final Map<String, Boolean> gameManager = new HashMap<>();
    private int currentSection = 1;
    private int trialCount = 0;

    public BridgeGame(int bridgeSize) {
        this.bridge = new Bridge(bridgeSize);
        this.currentBridge = new CurrentBridge();
    }

    public CurrentBridge move(String readMoving) {
        currentBridge.setSection(bridge.askCurrentShape(currentSection), readMoving);
        setGameManager();
        currentSection++;
        return currentBridge;
    }

    public void retry() {
        this.currentBridge = new CurrentBridge();
        this.gameManager.clear();
        this.currentSection = 1;
    }

    private void setGameManager() {
        boolean isSuccessGame = currentBridge.isSuccessLastSection();
        boolean isLastSection = bridge.isLastBridgeSection(currentSection);
        if (!isSuccessGame || isLastSection) {
            gameManager.putAll(Map.of("isOneGameEnd", true, "isSuccessGame", isSuccessGame));
            trialCount++;
            return;
        }
        gameManager.put("isOneGameEnd", false);
    }

    public Map<String, Boolean> getGameManager() {
        return gameManager;
    }

    public int getTrialCount() {
        return trialCount;
    }
}
