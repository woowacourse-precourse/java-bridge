package bridge.domain.result;

import bridge.domain.game.Bridge;
import bridge.domain.game.Position;
import java.util.ArrayList;
import java.util.List;

public class MovedPositions {

    private final List<Position> movedPositions = new ArrayList<>();
    private final Bridge bridge;

    public MovedPositions(Bridge bridge) {
        this.bridge = bridge;
    }

    public void resetMovedPosition() {
        movedPositions.clear();
    }

    public void addMovedPositions(Position position) {
        movedPositions.add(position);
    }

    public Result makeResult(int distance) {
        List<ResultType> upDirections = new ArrayList<>();
        List<ResultType> downDirections = new ArrayList<>();
        traverseMovedPositions(upDirections, downDirections);
        return new Result(upDirections, downDirections, distance);
    }

    private void traverseMovedPositions(List<ResultType> upDirections, List<ResultType> downDirections) {
        movedPositions
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
