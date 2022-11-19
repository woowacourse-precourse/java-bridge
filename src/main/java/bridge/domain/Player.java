package bridge.domain;

import java.util.EnumMap;
import java.util.Map;

public class Player {
    private int moveDistance;
    private Map<Move, StringBuilder> playerMoved;

    public Player(int moveDistance, Map<Move, StringBuilder> playerMoved) {
        this.moveDistance = 0;
        this.playerMoved = new EnumMap<Move, StringBuilder>(Move.class);
        initMap();
    }

    private void initMap() {
        playerMoved.put(Move.UP, new StringBuilder());
        playerMoved.put(Move.DOWN, new StringBuilder());
    }

    public Map<Move, StringBuilder> moveTo(Bridge bridge, String direction) {
        for (Move move : Move.values()) {
            playerMoved.get(move).append(bridge.moveResult(move, moveDistance, direction));
        }

        return playerMoved;
    }
}
