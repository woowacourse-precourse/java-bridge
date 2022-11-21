package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeDirection;
import bridge.domain.player.Player;

import java.util.ArrayList;
import java.util.List;

import static bridge.common.Constants.BRIDGE_LENGTH;

public class BridgeGame {
    private static final String MOVABLE = "O";
    private static final String IMMOVABLE = "X";
    private static final String SPACE = " ";
    private final Bridge bridge;
    private final Player player;
    private List<List<String>> map;
    public boolean isMovable = true;

    private BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }

    public static BridgeGame of(Bridge bridge, Player player) {
        BridgeGame bridgeGame = new BridgeGame(bridge, player);
        bridgeGame.map = new ArrayList<>();
        for (int i = 0; i < BRIDGE_LENGTH; i++) {
            bridgeGame.map.add(new ArrayList<>());
        }
        return bridgeGame;
    }

    public List<List<String>> move() {
        for (int i = 0; i < BRIDGE_LENGTH; i++) {
            BridgeDirection bridgeDirection = BridgeDirection.of(i ^ 1);
            map.get(i).add(getMoveResult(bridgeDirection));
        }
        return map;
    }

    private String getMoveResult(BridgeDirection direction) {
        if (player.equalsTop(direction) && bridge.isMovable(player)) {
            return MOVABLE;
        }

        if (player.equalsTop(direction) && !bridge.isMovable(player)) {
            isMovable = false;
            return IMMOVABLE;
        }

        return SPACE;
    }

    public void retry() {

    }

    public List<List<String>> getMap() {
        return map;
    }
}
