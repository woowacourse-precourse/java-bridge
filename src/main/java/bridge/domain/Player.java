package bridge.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Player {
    private int moveDistance;
    private Map<Move, List<MoveResult>> moveResults = new EnumMap<>(Move.class);
    private int lifeCount;

    public Map<Move, List<MoveResult>> getMoveResults() {
        return moveResults;
    }

    private void initMoveResults() {
        moveResults.clear();
        moveResults.put(Move.UP, new ArrayList<>());
        moveResults.put(Move.DOWN, new ArrayList<>());
    }

    public void newLife() {
        lifeCount++;
        moveDistance = 0;
        initMoveResults();
    }

    public boolean move(Bridge bridge, String direction) {
        moveResults.get(Move.reverseMove(direction)).add(MoveResult.OTHER);

        MoveResult moveResult = bridge.crossBridge(moveDistance, direction);
        moveResults.get(Move.from(direction)).add(moveResult);
        moveDistance++;

        return moveResult.canMove;
    }
}
