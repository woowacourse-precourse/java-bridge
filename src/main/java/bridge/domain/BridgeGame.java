package bridge.domain;

import java.util.List;

import bridge.constant.Direction;
import bridge.dto.TrialResult;

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

    public TrialResult move(Direction direction) {
        boolean wasSuccessful = player.moveNext(direction);
        return new TrialResult(direction, wasSuccessful);
    }

    public void retry() {
        player = new Player(bridge);
    }

    public boolean isFinished() {
        return player.isArrived();
    }
}
