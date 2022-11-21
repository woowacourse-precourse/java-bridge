package bridge.domain;

import java.util.List;

import bridge.constant.Direction;

public class BridgeGame {

    private final Bridge bridge;
    private Player player;

    private BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.player = new Player(bridge);
    }

    static BridgeGame fromDirections(List<Direction> directions) {
        return new BridgeGame(Bridge.fromDirections(directions));
    }

    public static BridgeGame from(List<String> capitalLetters) {
        return new BridgeGame(Bridge.from(capitalLetters));
    }

    public boolean move(Direction direction) {
        return player.moveNext(direction);
    }

    public void retry() {
        player = new Player(bridge);
    }

    public boolean isFinished() {
        return player.isArrived();
    }
}
