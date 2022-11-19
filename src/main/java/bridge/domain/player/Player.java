package bridge.domain.player;

public class Player {
    public static final int INIT_DISTANCE = 0;

    private final AttemptCount attemptCount;
    private final MovedDistance movedDistance;

    private Player(MovedDistance movedDistance, AttemptCount attemptCount) {
        this.movedDistance = movedDistance;
        this.attemptCount = attemptCount;
    }

    public static Player of(int movedDistance, int attemptCount) {
        MovedDistance playerMovedDistance = MovedDistance.from(movedDistance);
        AttemptCount playerAttemptCount = AttemptCount.from(attemptCount);

        return new Player(playerMovedDistance, playerAttemptCount);
    }

    public Player increaseMovedDistance() {
        return new Player(movedDistance.increaseDistance(), attemptCount);
    }

    public MovedDistance getMovedDistance() {
        return movedDistance;
    }

    public Player backToStartPoint() {
        return Player.of(INIT_DISTANCE, attemptCount.toInt());
    }
}
