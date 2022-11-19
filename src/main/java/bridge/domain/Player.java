package bridge.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Player {
    private int moveDistance;
    private Map<Move, List<MoveResult>> moveResults;
    private int lifeCount;

    public Player() {
        this.moveResults = new EnumMap<>(Move.class);
        initMoveResults();
    }

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

    public boolean move(Bridge bridge, Move moveTo) {
        moveResults.get(Move.reverseMove(moveTo)).add(MoveResult.OTHER);

        MoveResult moveResult = bridge.crossBridge(moveDistance, moveTo);
        moveResults.get(moveTo).add(moveResult);
        moveDistance++;

        return moveResult.canMove;
    }
}
