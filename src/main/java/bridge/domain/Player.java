package bridge.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Player {
    private int moveDistance;
    private Map<Move, List<MoveResult>> moveResults;

    public Player() {
        this.moveDistance = 0;
        this.moveResults = new EnumMap<>(Move.class);
        initMap();
    }

    public Map<Move, List<MoveResult>> getMoveResults() {
        return moveResults;
    }

    private void initMap() {
        moveResults.put(Move.UP, new ArrayList<>());
        moveResults.put(Move.DOWN, new ArrayList<>());
    }

    public boolean move(Bridge bridge, String direction) {
        moveResults.get(Move.reverseMove(direction)).add(MoveResult.OTHER);

        MoveResult moveResult = bridge.crossBridge(moveDistance, direction);
        moveResults.get(Move.from(direction)).add(moveResult);
        moveDistance++;

        return moveResult.canMove;
    }
}
