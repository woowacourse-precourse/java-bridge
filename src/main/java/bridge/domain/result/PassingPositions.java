package bridge.domain.result;

import bridge.domain.bridgeInfo.Bridge;
import bridge.domain.userInfo.Position;
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
        List<PassingDirectionType> upDirections = new ArrayList<>();
        List<PassingDirectionType> downDirections = new ArrayList<>();
        moveLoop(upDirections, downDirections);
        return new Result(upDirections, downDirections, distance);
    }

    private void moveLoop(List<PassingDirectionType> upDirections, List<PassingDirectionType> downDirections) {
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

    private void moveToUp(List<PassingDirectionType> upDirections, List<PassingDirectionType> downDirections, Position position) {
        upDirections.add(PassingDirectionType.getSelectedDirection(position, bridge));
        downDirections.add(PassingDirectionType.getNotSelectedDirection(position));
    }

    private void moveToDown(List<PassingDirectionType> upDirections, List<PassingDirectionType> downDirections, Position position) {
        upDirections.add(PassingDirectionType.getNotSelectedDirection(position));
        downDirections.add(PassingDirectionType.getSelectedDirection(position, bridge));
    }
}
