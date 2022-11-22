package bridge.domain.bridge_game;

public class Player {

    private Position position;
    private NumberOfChallenges numberOfChallenges;

    public Player(final Position position, final NumberOfChallenges numberOfChallenges) {
        this.position = position;
        this.numberOfChallenges = numberOfChallenges;
    }

    boolean isOnTheBridge(final Bridge bridge) {
        return bridge.isLongerThan(position);
    }

    void move() {
        position = position.increase();
    }

    void resetPosition() {
        position = position.reset();
    }

    void increaseChallenges() {
        numberOfChallenges = numberOfChallenges.increase();
    }

    int position() {
        return position.value();
    }

    int numberOfChallenges() {
        return numberOfChallenges.value();
    }
}
