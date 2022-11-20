package bridge.domain;

import java.util.List;

public class Result {
    private final ResultType resultType;
    private final List<String> crossedBridge;

    private Result(ResultType resultType, List<String> crossedBridge) {
        this.resultType = resultType;
        this.crossedBridge = crossedBridge;
    }

    public static Result success(List<String> crossedBridge) {
        return new Result(ResultType.SUCCESS, crossedBridge);

    }

    public static Result fail(List<String> crossedBridge) {
        return new Result(ResultType.FAIL, crossedBridge);
    }

    public boolean isSucceeded() {
        return resultType.equals(ResultType.SUCCESS);
    }

}
