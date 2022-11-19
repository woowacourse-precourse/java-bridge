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
                addUp(compare, upDirections, downDirections);
            }
            if (!position.getDirection().isUpper()) {
                addDown(compare, upDirections, downDirections);
            }
        }
        return new Result(upDirections, downDirections);
    }

    private void addUp(String compare, List<String> upDirections, List<String> downDirections) {
        upDirections.add(SEPARATOR);
        upDirections.add(compare);
        downDirections.add(SEPARATOR);
        downDirections.add(SPACE);
    }

    private void addDown(String compare, List<String> upDirections, List<String> downDirections) {
        upDirections.add(SEPARATOR);
        upDirections.add(SPACE);
        downDirections.add(SEPARATOR);
        downDirections.add(compare);
    }
}
