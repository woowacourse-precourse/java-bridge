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

    public int size() {
        return moveResults.size();
    }

    public boolean success(){
       return moveResults.get(size()-1).isMatchResult();
    }

    public List<MoveResult> getMoveResults() {
        return moveResults;
    }
}
