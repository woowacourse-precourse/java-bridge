package bridge.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Player {
    private final Map<Move, List<MoveResult>> moveResults = new EnumMap<>(Move.class);
    private int moveDistance;
    private int lifeCount;

    public Player() {
        this.lifeCount = 1;
        initMoveResults();
    }

    public Map<Move, List<MoveResult>> getMoveResults() {
        return moveResults;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public int getLifeCount() {
        return lifeCount;
    }

    private void initMoveResults() {
        for (Move move : Move.values()) {
            moveResults.put(move, new ArrayList<>());
        }
    }

    public void newLife() {
        lifeCount++;
        moveDistance = 0;
        initMoveResults();
    }

    public MoveResult move(Bridge bridge, Move moveTo) {
        MoveResult moveResult = bridge.crossBridge(moveDistance, moveTo);
        moveResults.get(moveTo).add(moveResult);
        moveResults.get(Move.other(moveTo)).add(MoveResult.OTHER);
        moveDistance++;

        return moveResult;
    }
}
