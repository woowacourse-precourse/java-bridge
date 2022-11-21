package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PassingPositions {

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
        List<DirectionType> upDirections = new ArrayList<>();
        List<DirectionType> downDirections = new ArrayList<>();
        moveLoop(upDirections, downDirections);
        return new Result(upDirections, downDirections, distance);
    }

    private void moveLoop(List<DirectionType> upDirections, List<DirectionType> downDirections) {
        passingPositions
                .forEach(position -> {
                    if (position.getDirection().isSameUp()) {
                        moveToUp(upDirections, downDirections, position);
                    }
                    if (position.getDirection().isSameDown()) {
                        moveToDown(upDirections, downDirections, position);
                    }
                });
    }

    private void moveToUp(List<DirectionType> upDirections, List<DirectionType> downDirections, Position position) {
        upDirections.add(DirectionType.getSelectedDir(position, bridge));
        downDirections.add(DirectionType.getNotSelectedDir(position));
    }

    private void moveToDown(List<DirectionType> upDirections, List<DirectionType> downDirections, Position position) {
        upDirections.add(DirectionType.getNotSelectedDir(position));
        downDirections.add(DirectionType.getSelectedDir(position, bridge));
    }
}
