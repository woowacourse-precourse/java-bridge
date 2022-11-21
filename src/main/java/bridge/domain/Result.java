package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {

    private static final int PREVIOUS = -1;
    private final List<List<PassingDirectionType>> resultsGroup = new ArrayList<>();
    private int distance;

    public Result(List<PassingDirectionType> upDirections, List<PassingDirectionType> downDirections, int distance) {
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

    public List<List<PassingDirectionType>> getResultsGroup() {
        return Collections.unmodifiableList(resultsGroup);
    }

    // X 가 포함되어 있는지
    public boolean isContainWrongAnswer() {
        for (List<PassingDirectionType> results : resultsGroup) {
            if (PassingDirectionType.isContainX(results)) {
                return true;
            }
        }
        return false;
    }
}
