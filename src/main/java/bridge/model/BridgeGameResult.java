package bridge.model;

public class BridgeGameResult {
    private int tryCount;
    private boolean isSuccess;
    private MovementRecord lastMovementRecord;

    public BridgeGameResult() {
        // TODO 구현 필요
    }

    public void addTryCount() {
        // TODO 구현 필요
    }

    public void makeResultSuccess() {
        // TODO 구현 필요
    }

    public void clearLastMovementRecord() {
        // TODO 구현 필요
    }

    public void addMovementOnLastMovementRecord(SpotInfo spotInfo) {
        // TODO 구현 필요
    }

    public int getTryCount() {
        // TODO 구현 필요
        return 0;
    }

    public boolean isSuccess() {
        // TODO 구현 필요
        return true;
    }

    public SpotInfo getLastMovementRecord(int index) {
        // TODO 구현 필요
        return SpotInfo.UP;
    }
}
