package bridge.model;

import bridge.model.constant.MoveDirection;
import java.util.List;
import java.util.Optional;

public class GameStatus {

    private Optional<Integer> tryCount;
    private boolean fail;
    private List<MoveDirection> moveDirections;

    public GameStatus(Optional<Integer> tryCount, boolean fail,
            List<MoveDirection> moveDirections) {
        this.tryCount = tryCount;
        this.fail = fail;
        this.moveDirections = moveDirections;
    }

    public Integer tryCount() {
        return tryCount.get();
    }

    public boolean fail() {
        return fail;
    }

    public List<MoveDirection> getMoveChoices() {
        return moveDirections;
    }
}
