package bridge.domain;

public class Player {

    private int position;
    private int totalNumberOfChallenges;

    public Player(final int position, final int totalNumberOfChallenges) {
        this.position = position;
        this.totalNumberOfChallenges = totalNumberOfChallenges;
    }

    int position() {
        return position;
    }

    boolean positionIsNotMoreThan(final BridgeSize bridgeSize) {
        return bridgeSize.isMoreThan(position);
    }

    void move() {
        position++;
    }

    void initPosition() {
        position = 0;
    }

    void increaseNumberOfChallenges() {
        totalNumberOfChallenges++;
    }

    int totalNumberOfChallenges() {
        return totalNumberOfChallenges;
    }
}
