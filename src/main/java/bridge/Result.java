package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<ResultType> firstRow;
    private List<ResultType> secondRow;
    private int count;

    Result() {
        firstRow = new ArrayList<ResultType>();
        secondRow = new ArrayList<ResultType>();
        count = 0;
    }

    public void appendResult(ResultType resultType, Direction direction) {
        if (direction == Direction.UP) {
            firstRow.add(resultType);
            secondRow.add(ResultType.EMPTY);
            count += 1;
            return;
        }
        if (direction == Direction.DOWN) {
            firstRow.add(ResultType.EMPTY);
            secondRow.add(resultType);
            return;
        }
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
}
