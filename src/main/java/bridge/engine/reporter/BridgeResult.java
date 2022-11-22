package bridge.engine.reporter;

public class BridgeResult {

    private String result;
    private String isSuccess;
    private int tryCount;

    public BridgeResult(String result, String isSuccess, int tryCount) {
        this.result = result;
        this.isSuccess = isSuccess;
        this.tryCount = tryCount;
    }

    public String getResult() {
        return result;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public int getTryCount() {
        return tryCount;
    }
}
