package bridge.model;

import bridge.model.constant.MoveChoice;
import java.util.List;
import java.util.Optional;

public class GameResult {

    private Optional<Integer> tryCount;
    private boolean succeed;
    private List<MoveChoice> moveChoices;

    public GameResult(Optional<Integer> tryCount, boolean succeed,
            List<MoveChoice> moveChoices) {
        this.tryCount = tryCount;
        this.succeed = succeed;
        this.moveChoices = moveChoices;
    }

    public Integer tryCount() {
        return tryCount.get();
    }

    public boolean succeed() {
        return succeed;
    }

    public List<MoveChoice> getMoveChoices() {
        return moveChoices;
    }
}
