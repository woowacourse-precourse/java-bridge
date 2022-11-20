package bridge.model;

public class BridgeGameResult {
    private int tryCount;
    private boolean isSuccess;
    private final MovementRecord lastMovementRecord;

    public BridgeGameResult() {
        tryCount = 0;
        isSuccess = false;
        lastMovementRecord = new MovementRecord();
    }

    public void reset() {
        tryCount = 0;
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
