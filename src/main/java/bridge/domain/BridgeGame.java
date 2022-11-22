package bridge.domain;

import java.util.List;

import bridge.constant.Direction;

public class BridgeGame {

    private final Bridge bridge;
    private Player player;
    private final TrialCount trialCount;

    private BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.player = new Player(bridge);
        this.trialCount = new TrialCount();
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
        trialCount.increase();
    }

    public boolean isFinished() {
        return player.isArrived();
    }

    public int getTrialCount() {
        return trialCount.getCount();
    }
}
