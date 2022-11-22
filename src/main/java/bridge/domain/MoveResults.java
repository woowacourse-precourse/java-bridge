package bridge.domain;

import bridge.BridgeKey;
import bridge.CrossResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MoveResults {
    private final List<MoveResult> moveResults = new ArrayList<>();


    private int tryNum = 1;

    public void addResult(MoveResult moveResult) {
        moveResults.add(moveResult);
    }

    public void removeFailure() {
        moveResults.removeIf(moveResult -> !moveResult.isMatchResult());
    }

    public int size() {
        return moveResults.size();
    }

    public boolean success() {
        if (moveResults.isEmpty()) {
            return true;
        }
        return moveResults.get(size() - 1).isMatchResult();
    }

    public void addTryNum() {
        tryNum++;
    }

    public List<MoveResult> getMoveResults() {
        return moveResults;
    }

    public int getTryNum() {
        return tryNum;
    }
}
