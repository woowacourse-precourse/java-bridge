package bridge.domain;

public class GameStatus {
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

    public int getTryCount() {
        return tryCount;
    }

    public void addTryCount() {
        this.tryCount++;
    }


    public static GameStatus startNewGame() {
        return new GameStatus();
    }
}
