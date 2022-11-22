package bridge.domain;

import java.util.List;

import bridge.constant.Direction;

public class BridgeGame {
    private static final int INITIAL_TRIAL_COUNT = 1;
    private static final int TRIAL_COUNT_INCREASE_AMOUNT = 1;

    private final Bridge bridge;
    private Player player;
    private int trialCount = INITIAL_TRIAL_COUNT;

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
        trialCount += TRIAL_COUNT_INCREASE_AMOUNT;
    }

    public boolean isFinished() {
        return player.isArrived();
    }

    public int getTrialCount() {
        return trialCount;
    }
}
