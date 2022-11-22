package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<ResultType> firstRow;
    private List<ResultType> secondRow;
    private ResultType lastResultType;
    private int tryCount;

    Result(int count) {
        firstRow = new ArrayList<ResultType>();
        secondRow = new ArrayList<ResultType>();
        lastResultType = ResultType.FAIL;
        tryCount = count;
    }

    public void appendResult(ResultType resultType, Direction direction) {
        lastResultType = resultType;
        if (direction == Direction.UP) {
            firstRow.add(resultType);
            secondRow.add(ResultType.EMPTY);
        }
        if (direction == Direction.DOWN) {
            firstRow.add(ResultType.EMPTY);
            secondRow.add(resultType);
        }
    }

    public List<ResultType> getFirstRow() {
        return firstRow;
    }

    public List<ResultType> getSecondRow() {
        return secondRow;
    }

    public int getCount() {
        return tryCount + 1;
    }

    public ResultType getLastResultType() {
        return lastResultType;
    }
}
