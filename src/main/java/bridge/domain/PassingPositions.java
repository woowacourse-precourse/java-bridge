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

    public Result makeResult(int distance) {
        List<String> upDirections = new ArrayList<>();
        List<String> downDirections = new ArrayList<>();
        moveLoop(upDirections, downDirections);
        return new Result(upDirections, downDirections, distance);
    }

    private void moveLoop(List<String> upDirections, List<String> downDirections) {
        passingPositions
                .forEach(position -> {
                    if (position.getDirection().isSameUp()) {
                        moveToUp(bridge.compare(position), upDirections, downDirections);
                    }
                    if (position.getDirection().isSameDown()) {
                        moveToDown(bridge.compare(position), upDirections, downDirections);
                    }
                });
    }

    private void moveToUp(String compare, List<String> upDirections, List<String> downDirections) {
        moveToSelected(upDirections, compare);
        doNotMove(downDirections);
    }

    private void moveToDown(String compare, List<String> upDirections, List<String> downDirections) {
        moveToSelected(downDirections, compare);
        doNotMove(upDirections);
    }

    private void moveToSelected(List<String> selectedDirections, String compare) {
        selectedDirections.add(SEPARATOR);
        selectedDirections.add(compare);
    }

    private void doNotMove(List<String> notSelectedDirections) {
        notSelectedDirections.add(SEPARATOR);
        notSelectedDirections.add(SPACE);
    }
}
