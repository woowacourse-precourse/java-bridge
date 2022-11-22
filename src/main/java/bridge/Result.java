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

    /**
     * 다리의 한 줄을 추가한다.
     * 
     * @param resultType
     * @param direction
     */
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

    /**
     * 다리의 첫번째 줄을 추가한다.
     * 
     * @return 다리의 첫번째 줄
     */
    public List<ResultType> getFirstRow() {
        return firstRow;
    }

    /**
     * 다리의 두번째 줄을 추가한다.
     * 
     * @return 다리의 두번째 줄
     */
    public List<ResultType> getSecondRow() {
        return secondRow;
    }

    /**
     * 시도한 결과를 반환한다.
     * 
     * @return 시도한 결과
     */
    public int getCount() {
        return tryCount + 1;
    }

    /**
     * 마지막 움직임의 결과를 반환한다.
     * 
     * @return 마지막 움직임의 결과
     */
    public ResultType getLastResultType() {
        return lastResultType;
    }
}
