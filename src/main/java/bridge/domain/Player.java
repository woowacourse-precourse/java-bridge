package bridge.domain;

public class Player {

    private int position;
    private int numberOfChallenges;

    public Player(final int position, final int numberOfChallenges) {
        this.position = position;
        this.numberOfChallenges = numberOfChallenges;
    }

    int position() {
        return position;
    }

    boolean isOnTheBridge(final Bridge bridge) {
        return bridge.isLongerThan(position);
    }

    void move() {
        position++;
    }

    void resetPosition() {
        position = 0;
    }

    void increaseChallenges() {
        numberOfChallenges++;
    }

    int numberOfChallenges() {
        return numberOfChallenges;
    }
}
