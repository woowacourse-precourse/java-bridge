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
        List<Dir> upDirections = new ArrayList<>();
        List<Dir> downDirections = new ArrayList<>();
        moveLoop(upDirections, downDirections);
        return new Result(upDirections, downDirections, distance);
    }

    private void moveLoop(List<Dir> upDirections, List<Dir> downDirections) {
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

    private void moveToUp(List<Dir> upDirections, List<Dir> downDirections, Position position) {
        upDirections.add(Dir.getSelectedDir(position, bridge));
        downDirections.add(Dir.getNotSelectedDir(position));
    }

    private void moveToDown(List<Dir> upDirections, List<Dir> downDirections, Position position) {
        upDirections.add(Dir.getNotSelectedDir(position));
        downDirections.add(Dir.getSelectedDir(position, bridge));
    }
}
