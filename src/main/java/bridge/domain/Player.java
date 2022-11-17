package bridge.domain;

public class Player {

    private int position;
    private int totalNumberOfChallenges;

    public Player(int position, int totalNumberOfChallenges) {
        this.position = position;
        this.totalNumberOfChallenges = totalNumberOfChallenges;
    }

    int position() {
        return position;
    }

    boolean positionNotMoreThan(int bridgeSize) {
        return position < bridgeSize;
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
