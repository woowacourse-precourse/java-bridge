package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<List<String>> resultsGroup = new ArrayList<>();
    private final List<String> upElements = new ArrayList<>();
    private final List<String> downElements = new ArrayList<>();

    public Result(Bridge bridge, PassingPositions passingPositions) {
        makeResultsGroup(bridge, passingPositions);
        resultsGroup.add(upElements);
        resultsGroup.add(downElements);
    }

    public void makeResultsGroup(Bridge bridge, PassingPositions passingPositions) {
        List<Position> passingPosition = passingPositions.getPassingPositions();
        for (Position position : passingPosition) {
            String compare = bridge.compare(position);
            addUpAndDown(position, compare);
        }
    }

    private void addUpAndDown(Position position, String compare) {
        if (position.getElementIndex().equals("U")) {
            upElements.add(compare);
            downElements.add(" ");
        }
        if (position.getElementIndex().equals("D")) {
            upElements.add(" ");
            downElements.add(compare);
        }
    }

    public List<List<String>> getResultsGroup() {
        return resultsGroup;
    }

    public List<String> makeCompares(Bridge bridge, PassingPositions passingPositions) {
        List<String> compares = new ArrayList<>();
        List<Position> passingPosition = passingPositions.getPassingPositions();
        for (Position position : passingPosition) {
            String compare = bridge.compare(position);
            compares.add(compare);
        }
        return compares;
    }
}
