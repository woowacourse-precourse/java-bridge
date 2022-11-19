package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.CurrentBridge;

import java.util.HashMap;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final CurrentBridge currentBridge;
    private final Map<String, Boolean> gameManager = new HashMap<>();
    private int currentSection = 1;
    private int trialCount = 0;

    public BridgeGame(int bridgeSize) {
        this.bridge = new Bridge(bridgeSize);
        this.currentBridge = new CurrentBridge();
    }

    public CurrentBridge move(String readMoving) {
        currentBridge.setSection(bridge.askCurrentShape(currentSection), readMoving);
        currentSection++;
        setGameManager();
        return currentBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private void setGameManager() {
        boolean isSuccessGame = currentBridge.isSuccessLastSection();
        boolean isLastSection = bridge.getBridgeLength() == currentBridge.getCurrentBridgeLength();
        if (!isSuccessGame || isLastSection) {
            trialCount++;
            gameManager.putAll(Map.of("isGameEnd", true, "isSuccessGame", isSuccessGame));
            return;
        }
        gameManager.put("isGameEnd", false);
    }

    public Map<String, Boolean> getGameManager() {
        return gameManager;
    }

    public int getTrialCount() {
        return trialCount;
    }
}
