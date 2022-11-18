package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private static final String SEPARATOR = " | ";
    private static final String SPACE = " ";
    private final List<List<String>> resultsGroup = new ArrayList<>();
    private final List<String> upDirections = new ArrayList<>();
    private final List<String> downDirections = new ArrayList<>();

    private final Bridge bridge;
    private final PassingPositions passingPositions;

    public Result(Bridge bridge, PassingPositions passingPositions) {
        this.bridge = bridge;
        this.passingPositions = passingPositions;

        makeResultsGroup();
        upDirections.remove(0);
        resultsGroup.add(upDirections);
        downDirections.remove(0);
        resultsGroup.add(downDirections);
    }

    public void makeResultsGroup() {
        List<Position> passingPosition = passingPositions.getPassingPositions();
        for (Position position : passingPosition) {
            String compare = bridge.compare(position);
            addUpAndDown(position, compare);
        }
    }

    private void addUpAndDown(Position position, String compare) {
        if (position.getDirection().equals("U")) {
            upDirections.add(SEPARATOR);
            upDirections.add(compare);
            downDirections.add(SEPARATOR);
            downDirections.add(SPACE);
        }
        if (position.getDirection().equals("D")) {
            upDirections.add(SEPARATOR);
            upDirections.add(SPACE);
            downDirections.add(SEPARATOR);
            downDirections.add(compare);
        }
    }

    public List<List<String>> getResultsGroup() {
        return resultsGroup;
    }

    public List<String> makeCompares() {
        List<String> compares = new ArrayList<>();
        List<Position> passingPosition = passingPositions.getPassingPositions();
        for (Position position : passingPosition) {
            String compare = bridge.compare(position);
            compares.add(compare);
        }
        return compares;
    }
}
