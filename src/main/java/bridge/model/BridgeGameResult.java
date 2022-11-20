package bridge.model;

public class BridgeGameResult {
    private int tryCount;
    private boolean isSuccess;
    private boolean isFail;
    private final MovementRecord lastMovementRecord;

    public BridgeGameResult() {
        tryCount = 1;
        isSuccess = false;
        isFail = false;
        lastMovementRecord = new MovementRecord();
    }

    public BridgeGameResult(BridgeGameResult oth) {
        tryCount = oth.tryCount;
        isSuccess = oth.isSuccess;
        isFail = oth.isFail;
        lastMovementRecord = new MovementRecord(oth.lastMovementRecord);
    }

    public void resetFlag() {
        isSuccess = false;
        isFail = false;
    }

    public void addTryCount() {
        tryCount += 1;
    }

    public void makeResultSuccess() {
        isSuccess = true;
    }

    public void makeResultFail() {
        isFail = true;
    }

    public void clearLastMovementRecord() {
        lastMovementRecord.clearMovementRecord();
    }

    public void addMovementOnLastMovementRecord(BridgeLane spotInfo) {
        lastMovementRecord.addMovementRecord(spotInfo);
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFail() {
        return isFail;
    }

    public int getLastMovementCount() {
        return lastMovementRecord.getMovementCount();
    }

    public BridgeLane getLastMovementRecord(int index) {
        return lastMovementRecord.getMovementRecord(index);
    }
}
