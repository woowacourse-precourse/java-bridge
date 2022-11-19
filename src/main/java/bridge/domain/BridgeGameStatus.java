package bridge.domain;

public class BridgeGameStatus {
    private boolean status;
    private int tryCount;

    public BridgeGameStatus() {
        this.status = true;
        this.tryCount = 0;
    }

    public void addTryCount() {
    }

    public void endGame() {
    }

    public boolean canPlayGame() {
        return status;
    }

    public void updateStatus(boolean status){
        this.status = status;
    }

}
