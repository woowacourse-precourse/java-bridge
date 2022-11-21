package bridge;

import bridge.domain.Bridge;

public class GameStatus {
    private boolean isEnd = false;
    private boolean isSuccess = false;
    private int tryCount = 1;

    private Bridge realBridge;
    private Bridge selectedBridge = new Bridge();

    public Bridge getRealBridge() {
        return realBridge;
    }

    public void setRealBridge(Bridge realBridge) {
        this.realBridge = realBridge;
    }

    public Bridge getSelectedBridge() {
        return selectedBridge;
    }

    public void setSelectedBridge(Bridge selectedBridge) {
        this.selectedBridge = selectedBridge;
    }

    public void setNewSelectedBridge() {
        selectedBridge = new Bridge();
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        if (success) {
            isEnd = true;
        }
        isSuccess = success;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void addTryCount() {
        this.tryCount++;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public static GameStatus startNewGame() {
        return new GameStatus();
    }
}
