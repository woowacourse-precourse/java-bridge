package bridge.model;

import bridge.model.constant.MoveDirection;
import java.util.List;
import java.util.Optional;

public class GameResult {

    private Optional<Integer> tryCount;
    private boolean succeed;
    private List<MoveDirection> moveDirections;

    public GameResult(Optional<Integer> tryCount, boolean succeed,
            List<MoveDirection> moveDirections) {
        this.tryCount = tryCount;
        this.succeed = succeed;
        this.moveDirections = moveDirections;
    }

    public Integer tryCount() {
        return tryCount.get();
    }

    public boolean succeed() {
        return succeed;
    }

    public List<MoveDirection> getMoveChoices() {
        return moveDirections;
    }
}
