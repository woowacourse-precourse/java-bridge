package bridge.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Player {
    private int moveDistance;
    private Map<Move, List<String>> moveResult;

    public Player() {
        this.moveDistance = 0;
        this.moveResult = new EnumMap<>(Move.class);
        initMap();
    }

    public Map<Move, List<String>> getPlayerMoved() {
        return moveResult;
    }

    private void initMap() {
        moveResult.put(Move.UP, new ArrayList<>());
        moveResult.put(Move.DOWN, new ArrayList<>());
    }

    public void move(Bridge bridge, String direction) {
        for (Move move : Move.values()) {
            moveResult.get(move).add(bridge.moveResult(move, moveDistance, direction));
        }
        moveDistance++;
    }
}
