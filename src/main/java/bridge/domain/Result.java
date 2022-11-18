package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {

    private final List<List<String>> resultsGroup = new ArrayList<>();

    public Result(List<String> upDirections, List<String> downDirections) {
        upDirections.remove(0);
        downDirections.remove(0);
        resultsGroup.add(upDirections);
        resultsGroup.add(downDirections);
    }

    public List<List<String>> getResultsGroup() {
        return Collections.unmodifiableList(resultsGroup);
    }

    // X 가 포함되어 있는지
    public boolean isContainWrongAnswer() {
        for (List<String> results : resultsGroup) {
            if (results.contains("X")) {
                return true;
            }
        }
        return false;
    }
}
