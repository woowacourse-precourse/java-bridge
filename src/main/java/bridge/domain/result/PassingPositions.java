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
        List<ResultType> upDirections = new ArrayList<>();
        List<ResultType> downDirections = new ArrayList<>();
        moveLoop(upDirections, downDirections);
        return new Result(upDirections, downDirections, distance);
    }

    private void moveLoop(List<ResultType> upDirections, List<ResultType> downDirections) {
        passingPositions
                .forEach(position -> {
                    if (position.isDirectionUp()) {
                        moveToUp(upDirections, downDirections, position);
                    }
                    if (position.isDirectionDown()) {
                        moveToDown(upDirections, downDirections, position);
                    }
                });
    }

    private void moveToUp(List<ResultType> upDirections, List<ResultType> downDirections, Position position) {
        upDirections.add(ResultType.getSelectedDirection(position, bridge));
        downDirections.add(ResultType.getNotSelectedDirection(position));
    }

    private void moveToDown(List<ResultType> upDirections, List<ResultType> downDirections, Position position) {
        upDirections.add(ResultType.getNotSelectedDirection(position));
        downDirections.add(ResultType.getSelectedDirection(position, bridge));
    }
}
