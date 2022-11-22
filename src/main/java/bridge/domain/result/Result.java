package bridge.domain.result;

import bridge.domain.bridgeInfo.Length;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {

    private static final int PREVIOUS = -1;
    private final List<List<ResultType>> resultsGroup = new ArrayList<>();
    private int distance;

    public Result(List<ResultType> upDirections, List<ResultType> downDirections, int distance) {
        this.distance = distance + 1;
        resultsGroup.add(upDirections);
        resultsGroup.add(downDirections);
    }

    public boolean isSameDistanceAndLength(Length length) {
        return length.isSameLength(distance);
    }

    public void rollbackDistance() {
        distance += PREVIOUS;
    }

    public List<List<ResultType>> getResultsGroup() {
        return Collections.unmodifiableList(resultsGroup);
    }

    public boolean isContainWrongAnswer() {
        for (List<ResultType> results : resultsGroup) {
            if (ResultType.isContainNotMovable(results)) {
                return true;
            }
        }
        return false;
    }
}
