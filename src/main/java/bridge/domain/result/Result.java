package bridge.domain.result;

public class Result {
    private final Map map;
    private ResultType lastResultType;
    private int tryCount = 1;

    public Result(Map map) {
        this.map = map;
        this.lastResultType = ResultType.BLANK;
    }

    private void updateResult(ResultType resultType) {
        lastResultType = resultType;
    }

    public boolean isSucceeded() {
        return lastResultType.isSucceeded();
    }

    public void addUpBlock(ResultType resultType) {
        map.addUpBlock(resultType);
        updateResult(resultType);

    }

    public void addDownBlock(ResultType resultType) {
        map.addDownBlock(resultType);
        updateResult(resultType);
    }

    public Map toMap() {
        return map;
    }

    public void retry() {
        map.retry();
        tryCount++;
    }

    public boolean isFinished() {
        return lastResultType.isFinished();
    }

    //getter 없이 살아남기 도전
    public int getTryCount() {
        return tryCount;
    }
}
