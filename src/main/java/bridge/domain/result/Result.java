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

    public String toResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toMap()).append("'\n");
        if (isFinished()) {
            stringBuilder.append("게임 성공 여부: 성공\n");
            stringBuilder.append("총 시도한 횟수: ").append(this.tryCount);
            return stringBuilder.toString();
        }
        stringBuilder.append("게임 성공 여부: 실패\n");
        stringBuilder.append("총 시도한 횟수: ").append(this.tryCount);
        return stringBuilder.toString();
    }

    public void retry() {
        map.retry();
        tryCount++;
    }

    public boolean isFinished() {
        return lastResultType.isFinished();
    }
}
