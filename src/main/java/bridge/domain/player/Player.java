package bridge.domain.player;

public class Player {

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

    public int getMovedDistance() {
        return movedDistance.toInt();
    }

    public Player makeNewAttempt() {
        return new Player(movedDistance.reset(), attemptCount.increaseCount());
    }
}
