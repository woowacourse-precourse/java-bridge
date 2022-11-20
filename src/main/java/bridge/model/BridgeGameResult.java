package bridge.model;

public class BridgeGameResult {
    private int tryCount;
    private boolean isSuccess;
    private final MovementRecord lastMovementRecord;

    public BridgeGameResult() {
        tryCount = 1;
        isSuccess = false;
        lastMovementRecord = new MovementRecord();
    }

    public BridgeGameResult(BridgeGameResult oth) {
        tryCount = oth.tryCount;
        isSuccess = oth.isSuccess;
        lastMovementRecord = new MovementRecord(oth.lastMovementRecord);
    }

    public void reset() {
        tryCount = 1;
        isSuccess = false;
        lastMovementRecord.clearMovementRecord();
    }

    public void addTryCount() {
        tryCount += 1;
    }

    public void makeResultSuccess() {
        isSuccess = true;
    }

    public void clearLastMovementRecord() {
        lastMovementRecord.clearMovementRecord();
    }

    public void addMovementOnLastMovementRecord(SpotInfo spotInfo) {
        lastMovementRecord.addMovementRecord(spotInfo);
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public SpotInfo getLastMovementRecord(int index) {
        return lastMovementRecord.getMovementRecord(index);
    }
}
