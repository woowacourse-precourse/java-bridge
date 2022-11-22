package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<ResultType> firstRow;
    private List<ResultType> secondRow;
    private ResultType lastResultType;
    private int count;

    Result() {
        firstRow = new ArrayList<ResultType>();
        secondRow = new ArrayList<ResultType>();
        lastResultType = ResultType.FAIL;
        count = 0;
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
        count += 1;
    }

    public List<ResultType> getFirstRow() {
        return firstRow;
    }

    public List<ResultType> getSecondRow() {
        return secondRow;
    }

    public int getCount() {
        return count;
    }

    public ResultType getLastResultType() {
        return lastResultType;
    }
}
