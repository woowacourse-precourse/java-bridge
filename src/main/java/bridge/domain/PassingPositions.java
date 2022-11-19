package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PassingPositions {

    private static final String SEPARATOR = " | ";
    private static final String SPACE = " ";
    private final List<Position> passingPositions = new ArrayList<>();
    private final Bridge bridge;

    public PassingPositions(Bridge bridge) {
        this.bridge = bridge;
    }

    public void resetPassingPosition() {
        passingPositions.clear();
    }

    public void addPassingPositions(Position position) {
        passingPositions.add(position);
    }

    public Result makeResult() {
        List<String> upDirections = new ArrayList<>();
        List<String> downDirections = new ArrayList<>();
        for (Position position : passingPositions) {
            String compare = bridge.compare(position);
            if (position.getDirection().isUpper()) {
                movableWithUp(compare, upDirections, downDirections);
            }
            if (!position.getDirection().isUpper()) {
                movableWithDown(compare, upDirections, downDirections);
            }
        }
        return new Result(upDirections, downDirections);
    }

    private void movableWithUp(String compare, List<String> upDirections, List<String> downDirections) {
        addMovableDirection(upDirections, compare);
        addWrongDirection(downDirections);
    }

    private void movableWithDown(String compare, List<String> upDirections, List<String> downDirections) {
        addMovableDirection(downDirections, compare);
        addWrongDirection(upDirections);
    }

    private void addMovableDirection(List<String> directions, String compare) {
        directions.add(SEPARATOR);
        directions.add(compare);
    }

    private void addWrongDirection(List<String> directions) {
        directions.add(SEPARATOR);
        directions.add(SPACE);
    }
}
