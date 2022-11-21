package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {

    private final List<List<Dir>> resultsGroup = new ArrayList<>();
    private int distance;

    public Result(List<Dir> upDirections, List<Dir> downDirections, int distance) {
        this.distance = distance + 1;
        resultsGroup.add(upDirections);
        resultsGroup.add(downDirections);
    }

    public boolean isSameDistanceAndLength(Length length) {
        return length.isSameLength(distance);
    }

    public void rollbackDistance() {
        distance -= 1;
    }

    public List<List<Dir>> getResultsGroup() {
        return Collections.unmodifiableList(resultsGroup);
    }

    // X 가 포함되어 있는지
    public boolean isContainWrongAnswer() {
        for (List<Dir> results : resultsGroup) {
            if (Dir.isContainX(results)) {
                return true;
            }
        }
        return false;
    }
}
