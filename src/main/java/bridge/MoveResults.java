package bridge;

import java.util.ArrayList;
import java.util.List;

public class MoveResults {
    private final List<MoveResult> moveResults = new ArrayList<>();

    public void addResult(MoveResult moveResult) {
        moveResults.add(moveResult);
    }

    public void removeFailure() {
        moveResults.removeIf(moveResult -> !moveResult.isMatchResult());
    }


    public List<MoveResult> getMoveResults() {
        return moveResults;
    }
}
