package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private static final String SEPARATOR = " | ";
    private static final String SPACE = " ";
    private final List<List<String>> resultsGroup = new ArrayList<>();
    private final List<String> upElements = new ArrayList<>();
    private final List<String> downElements = new ArrayList<>();

    private final Bridge bridge;
    private final PassingPositions passingPositions;

    public Result(Bridge bridge, PassingPositions passingPositions) {
        this.bridge = bridge;
        this.passingPositions = passingPositions;

        makeResultsGroup();
        upElements.remove(0);
        resultsGroup.add(upElements);
        downElements.remove(0);
        resultsGroup.add(downElements);
    }

    public void makeResultsGroup() {
        List<Position> passingPosition = passingPositions.getPassingPositions();
        for (Position position : passingPosition) {
            String compare = bridge.compare(position);
            addUpAndDown(position, compare);
        }
    }

    private void addUpAndDown(Position position, String compare) {
        if (position.getElementIndex().equals("U")) {
            upElements.add(SEPARATOR);
            upElements.add(compare);
            downElements.add(SEPARATOR);
            downElements.add(SPACE);
        }
        if (position.getElementIndex().equals("D")) {
            upElements.add(SEPARATOR);
            upElements.add(SPACE);
            downElements.add(SEPARATOR);
            downElements.add(compare);
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
//    public List<String> makeCompares(Bridge bridge, PassingPositions passingPositions) {
//        List<String> compares = new ArrayList<>();
//        List<Position> passingPosition = passingPositions.getPassingPositions();
//        for (Position position : passingPosition) {
//            String compare = bridge.compare(position);
//            compares.add(compare);
//        }
//        return compares;
//    }
}
